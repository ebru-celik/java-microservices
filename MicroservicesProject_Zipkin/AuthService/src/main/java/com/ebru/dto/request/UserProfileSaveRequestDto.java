package com.ebru.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class UserProfileSaveRequestDto {

    Long authId;
    String username;
    String email;

}
