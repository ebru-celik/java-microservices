package com.ebru.controller;

import com.ebru.constant.EndPoint;
import com.ebru.dto.request.DoLoginRequestDto;
import com.ebru.dto.request.DoRegisterRequestDto;
import com.ebru.dto.response.DoRegisterResponseDto;
import com.ebru.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ebru.model.Auth;

import java.util.List;

import static com.ebru.constant.EndPoint.AUTH;


//    http://localhost:9090/auth
//@RequiredArgsConstructor
@RestController
@RequestMapping(AUTH)
public class AuthController {

    // injektion
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    //  Alternative: injection with lombok - @RequiredArgsConstructor
   // private final AuthService authService;

  /*  @PostMapping(EndPoint.REGISTER)
    public ResponseEntity<Auth> doRegister(@RequestBody DoRegisterRequestDto dto){
        return ResponseEntity.ok(authService.doRegister(dto));
    }
   */
    //http://localhost:9090/auth/register
    @PostMapping(EndPoint.REGISTER)
    public ResponseEntity<DoRegisterResponseDto> doRegister(@RequestBody DoRegisterRequestDto dto){
        System.out.println("DTO: " +  dto);
        return ResponseEntity.ok(authService.doRegister(dto));
    }

    //http://localhost:9090/auth/login
    @PostMapping(EndPoint.LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody DoLoginRequestDto dto){
        return ResponseEntity.ok(authService.doLogin(dto));
    }
    //without jwt token
    @GetMapping(EndPoint.GETALL)
    public ResponseEntity<List<Auth>> findAll()   {
        return ResponseEntity.ok(authService.findAll());
    }
    // with jwt token
    @GetMapping(EndPoint.GETALL_JWT)
    public ResponseEntity<List<Auth>> findAll(String token)   {
        return ResponseEntity.ok(authService.findAll(token));
    }

    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("AuthService Message!!");
    }

}