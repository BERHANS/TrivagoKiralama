package com.berhan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    SIFRE_UYUSMUYOR(1001,"Girilen Şifreler Uyuşmuyor",HttpStatus.BAD_REQUEST),
    KAYITLI_KULLANICI_ADI(1003,"Bu kullanıcı adı zaten kayıtlıdır",HttpStatus.BAD_REQUEST),
    USERNAME_PASSWORD_ERROR(1002,"Kullanıcı adı ya da şifre hatalı",HttpStatus.BAD_REQUEST),
    TOKEN_ERROR(1004,"Token üretilemedi,lütfen tekrar giriş yapmayı deneyin",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(3001,"Girilen bilgiler Hatalı, kontrol ederek tekrar giriniz.",HttpStatus.BAD_REQUEST);

    private int code ;
    private String message;
    private HttpStatus httpStatus;

}
