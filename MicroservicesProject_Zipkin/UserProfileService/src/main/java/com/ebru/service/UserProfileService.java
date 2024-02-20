package com.ebru.service;


import com.ebru.dto.request.UserProfileSaveRequestDto;
import com.ebru.mapper.IUserProfileMapper;
import com.ebru.model.UserProfile;
import com.ebru.repository.IUserProfileRepository;
import com.ebru.utils.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository repository;

    public UserProfileService(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public Boolean save(UserProfileSaveRequestDto dto) {

        save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
        return true;
    }




}