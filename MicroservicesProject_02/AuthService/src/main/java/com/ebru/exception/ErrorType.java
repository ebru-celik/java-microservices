package com.ebru.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    ABC_BULUNAMADI(1003,"The ABC you are looking for is not registered in the system", NOT_FOUND),
    ABC_EKLEME_HATASI(2001,"ABC insertion failed", INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER(3001,"You entered invalid parameters", HttpStatus.BAD_REQUEST),

    REGISTER_PASSWORD_MISMATCH(1004,"The entered passwords did not match.",HttpStatus.BAD_REQUEST),
    REGISTER_USERNAME_EXISTS(1005, "The username has already been taken.", HttpStatus.BAD_REQUEST),

    DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS(1006,"username or password ist wrong.",HttpStatus.BAD_REQUEST),

    INVALID_TOKEN(1007,"invalid token.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST(5001,"invalid request" ,HttpStatus.BAD_REQUEST ),
    INTERNAL_ERROR_SERVER(5100,"server error",INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    private HttpStatus status;
}
