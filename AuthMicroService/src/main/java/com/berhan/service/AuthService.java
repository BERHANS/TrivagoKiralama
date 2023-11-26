package com.berhan.service;

import com.berhan.dto.request.LoginRequestDto;
import com.berhan.dto.request.RegisterRequestDto;
import com.berhan.dto.request.UserProfileSaveRequestDto;
import com.berhan.exception.AuthException;
import com.berhan.exception.ErrorType;
import com.berhan.manager.UserProfileManager;
import com.berhan.mapper.AuthMapper;
import com.berhan.repository.AuthRepository;
import com.berhan.repository.entity.Auth;
import com.berhan.utility.JwtTokenManager;
import com.berhan.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    //@Autowired yazılırsa final yazılmaz ve başka repositoryleri eklemek istersek hepsine @Autowired eklememiz lazım
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;
    private final JwtTokenManager jwtTokenManager;
    public void register(RegisterRequestDto dto){
        /**
         * yeni üye olamak için gelen username veritabanında kayıtlı olup olmadığı kontrol edilir
         * eğer kullanıcı adı kayıtı ise hata fırlatılır.
         */
      repository.findOptionalByUserName(dto.getUserName())
                      .ifPresent(a->{throw new AuthException(ErrorType.KAYITLI_KULLANICI_ADI);});

        Auth auth = AuthMapper.INSTANCE.fromDto(dto);
        auth.setCreateAt(System.currentTimeMillis());
        auth.setUpdateAt(System.currentTimeMillis());
        auth.setState(State.AKTIF);
        repository.save(auth);
        /**
         * Kullanıcı yeni bir hesap açtığında auth bilgileri kayıt oluyor. Ancak kullanıcı uygulama içinde
         * UserProfile bilgisi ile hareket edeckek. bu nedenle register işleminde kullanıcının profil bilgilerinin
         * oluşturulması gerekir.
         */
//        userProfileManager.save(UserProfileSaveRequestDto.builder()
//                        .authId(auth.getId())
//                        .userName(auth.getUserName())
//                .build()); altttaki kod ile aynı işleve sahip

        userProfileManager.save(AuthMapper.INSTANCE.fromAuth(auth));
    }
    public String login(LoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByUserNameAndPassword(dto.getUsername(), dto.getPassword());
        if(auth.isEmpty())
            throw new AuthException(ErrorType.USERNAME_PASSWORD_ERROR);
        /**
         * kullanıcının authId bilgisi ile token üretiyoruz. bu token bilgisini dönücez
         */
        Optional<String> jwtToken = jwtTokenManager.createToken(auth.get().getId());
        if (jwtToken.isEmpty())
            throw new AuthException(ErrorType.TOKEN_ERROR);

        return jwtToken.get();
    }
}
