package com.ebru.service;


import com.ebru.dto.request.UserProfileSaveRequestDto;
import com.ebru.model.UserProfile;
import com.ebru.rabbitmq.model.AuthSaveModel;
import com.ebru.repository.IUserProfileRepository;
import com.ebru.utils.ServiceManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository repository;

    public UserProfileService(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public Boolean save(UserProfileSaveRequestDto dto) {

        save(UserProfile.builder()
                .authId(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
        return true;
    }


    // RabbitMq Listener
    @RabbitListener(queues = {"queue-auth"})
    public void createUserFromQueue(AuthSaveModel model){
        save(UserProfile.builder()
                .authId(model.getAuthId())
                .username(model.getUsername())
                .email(model.getEmail())
                .build());
    }

}