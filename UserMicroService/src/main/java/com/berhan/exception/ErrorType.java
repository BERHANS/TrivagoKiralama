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
    INVALID_TOKEN(1006,"Geersiz Token",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1010,"Böyle bir kullanıcı adı bulunamadı",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(3001,"Girilen bilgiler Hatalı, kontrol ederek tekrar giriniz.",HttpStatus.BAD_REQUEST);

    private int code ;
    private String message;
    private HttpStatus httpStatus;

}
