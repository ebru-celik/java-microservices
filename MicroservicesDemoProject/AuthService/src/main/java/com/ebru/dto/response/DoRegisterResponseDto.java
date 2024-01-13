package com.ebru.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoRegisterResponseDto {

    //@Size(min = 3, max = 50 )
    private String username;
    // @Email(message = "")
    private String email;

}
