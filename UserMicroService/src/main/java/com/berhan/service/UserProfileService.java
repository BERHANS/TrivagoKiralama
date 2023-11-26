package com.berhan.service;

import com.berhan.dto.request.GetProfileByTokenRequestDto;
import com.berhan.dto.request.UpdateProfileRequestDto;
import com.berhan.dto.request.UserProfileSaveRequestDto;
import com.berhan.dto.response.UserProfileResponseDto;
import com.berhan.exception.ErrorType;
import com.berhan.exception.UserException;
import com.berhan.mapper.UserProfileMapper;
import com.berhan.repository.UserProfileRepository;
import com.berhan.repository.entity.UserProfile;
import com.berhan.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserProfileService {
    private final UserProfileRepository repository;

    private final JwtTokenManager jwtTokenManager;
    public UserProfile save(UserProfileSaveRequestDto dto){
       return repository.save(UserProfileMapper.INSTANCE.fromDto(dto));
    }

    public UserProfileResponseDto getProfileByToken(GetProfileByTokenRequestDto dto) {
        /**
         * kullanıcı token bilgisini gönderiyor jwtManager ile token bilgisini doğruluyor ve içinden
         * kişinin authId bilgisini almaya çalışıyoruz
         */
        Optional<Long> authId = jwtTokenManager.getIdByToken(dto.getToken());
        if(authId.isEmpty())
            throw new UserException(ErrorType.INVALID_TOKEN);
       Optional<UserProfile> userProfile = repository.findOptionalByAuthId(authId.get());// bu durum mutlaka kontrol edilmesi gerekli
       if(userProfile.isEmpty())
           throw new UserException(ErrorType.USER_NOT_FOUND);
       return UserProfileMapper.INSTANCE.toUserProfileResponseDto(userProfile.get());
    }

    public Boolean updateProfile(UpdateProfileRequestDto dto) {
        Optional<Long> authId = jwtTokenManager.getIdByToken(dto.getToken());
        if(authId.isEmpty())
            throw new UserException(ErrorType.INVALID_TOKEN);
        Optional<UserProfile> userProfile = repository.findOptionalByAuthId(authId.get());
        if(userProfile.isEmpty())
            throw new UserException(ErrorType.USER_NOT_FOUND);

        UserProfile updateProfile = userProfile.get();
        updateProfile.setEmail(dto.getEmail());
        updateProfile.setName(dto.getName());
        updateProfile.setPhoto(dto.getPhoto());
        updateProfile.setPhone(dto.getPhone());
        repository.save(updateProfile);
        return true;
    }
}
