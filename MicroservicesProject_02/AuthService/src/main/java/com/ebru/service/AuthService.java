package com.ebru.service;

import com.ebru.dto.request.DoLoginRequestDto;
import com.ebru.dto.request.DoRegisterRequestDto;
import com.ebru.dto.response.DoRegisterResponseDto;
import com.ebru.exception.AuthServiceException;
import com.ebru.exception.ErrorType;
import com.ebru.manager.IUserProfileManager;
import com.ebru.mapper.IAuthMapper;
import com.ebru.model.Auth;
import com.ebru.repository.IAuthRepository;
import com.ebru.utils.JwtTokenManager;
import com.ebru.utils.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final JwtTokenManager jwtTokenManager;

    private final IUserProfileManager userProfileManager;

    public AuthService(IAuthRepository repository, JwtTokenManager jwtTokenManager, IUserProfileManager userProfileManager) {
        super(repository);
        authRepository = repository;
        this.jwtTokenManager = jwtTokenManager;
        this.userProfileManager = userProfileManager;
    }

    public DoRegisterResponseDto doRegister (DoRegisterRequestDto dto){

        System.out.println("DoRegisterRequestDto: " +  dto);


        // parola kontrolleri yapiliyor
        if (!dto.getPassword().equals(dto.getRepassword()))
            throw new AuthServiceException(ErrorType.REGISTER_PASSWORD_MISMATCH);


        /*
        Auth auth = new Auth();
        auth.setUsername(dto.getUsername());
        auth.setPassword(dto.getPassword());
        auth.setEmail(dto.getEmail());
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);
        save(auth); // KAYIT
        */

       /*
        // builder ile nesne - lombok ile nesne
        Auth auth = save(Auth.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .createAt(System.currentTimeMillis())
                .state(true)
                .build());
        */

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

        // auth.setCreateAt(System.currentTimeMillis());
        // auth.setState(true);
        save(auth); // KAYIT


/*        // Baska bir servisi cagiriyoruz
        userProfileManager.save(UserProfileSaveRequestDto.builder()
                .authId(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());
*/
        // Baska bir servisi mapper ile cagiriyoruz.
        userProfileManager.save(IAuthMapper.INSTANCE.toDto(auth));

        System.out.println("auth: " +  auth);

        DoRegisterResponseDto responseDto = new DoRegisterResponseDto();
        responseDto.setUsername(dto.getUsername());
        responseDto.setEmail(dto.getEmail());
        return responseDto;
    }

    /*
    // without JWT
    public Auth doLogin (DoLoginRequestDto dto){
        System.out.println("DoLoginRequestDto: "+dto);

        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        //  if (auth.isEmpty())
        //      throw new AuthServiceException(ErrorType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);

        return auth.get();
    }
     */
    public String doLogin1 (DoLoginRequestDto dto){
        System.out.println("DoLoginRequestDto: "+dto);

        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        if (auth.isEmpty())
            throw new AuthServiceException(ErrorType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);

        return auth.get().getId().toString();
    }

    // with JWT
    public String doLogin(DoLoginRequestDto dto) {

        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        if (auth.isEmpty())
            throw new AuthServiceException(ErrorType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);

        return jwtTokenManager.generateToken(auth.get().getId()).get();
    }

    public List<Auth> findAll(String token){
        Optional<Long> id = null;
        try{
            id = jwtTokenManager.decodeIdFromToken(token);
        }catch (Exception e){
            throw new AuthServiceException(ErrorType.INVALID_TOKEN);
        }

        if(findById(id.get()).isEmpty())
            throw new AuthServiceException(ErrorType.INVALID_TOKEN);

        return authRepository.findAll();
    }
}
