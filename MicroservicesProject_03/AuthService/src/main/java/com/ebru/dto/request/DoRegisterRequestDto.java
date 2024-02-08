package com.ebru.dto.request;

import com.ebru.constant.EndPoint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoRegisterRequestDto {

    //@Size(min = 3, max = 50 )
    private String username;
   // @Email(message = "")
    private String email;

    //@NotBlank (message = "")
   // @Pattern(regexp = EndPoint.PASSWORD_PATTERN)
    private String password;
    private String repassword;
}
