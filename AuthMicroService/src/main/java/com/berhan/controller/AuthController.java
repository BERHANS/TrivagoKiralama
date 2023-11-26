package com.berhan.controller;

import com.berhan.dto.request.LoginRequestDto;
import com.berhan.dto.request.RegisterRequestDto;
import com.berhan.dto.response.BaseResponseDto;
import com.berhan.dto.response.LoginResponseDto;
import com.berhan.dto.response.RegisterResponseDto;
import com.berhan.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.berhan.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService service;

    @Value("${buraya-canımın-istedigini-yazarim.okuyabilirim}")
    private String ifade;

    @GetMapping("/getmessage")
    public String message(){
        return "Bu Auth Servistir";
    }


   @PostMapping(REGISTER)
    /**
     * Login.html:1 Access to fetch at 'http://34.163.201.190:9090/api/v1/auth/register' from origin
     * 'http://localhost:63342' has been blocked by CORS policy: Response to preflight request doesn't pass access
     * control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
     * If an opaque response serves your needs, set the request's mode to 'no-cors' to fetch the resource with
     * CORS disabled.
     *
     * DİKKAT!!!
     * Yukarıda bulunan hata, sunucuya gelen isteği sunucunun dışından bir yerden gelmesi sonucunda oluşan bir hatadır.
     * bunu aşmak için sınıf,method yada secutiry ayarlarında istek atabilecek end-point leri tanımlamak gereklidir.
     *
     */
    @CrossOrigin("*")//cloudflare.com yazarsak ordan gelen isteklere cevap verir ya da kendi pc id mizi yazarız (*) yazarsak her yerden gelen isteklere ceva verir
    public ResponseEntity<BaseResponseDto<RegisterResponseDto>> register(@RequestBody @Valid RegisterRequestDto dto){
        service.register(dto);
        System.out.println("okunan ifade...:" +ifade);
        return ResponseEntity.ok(BaseResponseDto.<RegisterResponseDto>builder()
                        .responseCode(200)
                        .data(RegisterResponseDto.builder()
                                .isRegister(true)
                                .message("Üyelik başarıyla gerçekleştirildi")
                                .build())
                .build());
    }

    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody @Valid LoginRequestDto dto){
        String token = service.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                        .responseCode(200)
                        .data(LoginResponseDto.builder()
                                .isLogin(true)
                                .token(token)
                                .build())
                .build());
    }
}
