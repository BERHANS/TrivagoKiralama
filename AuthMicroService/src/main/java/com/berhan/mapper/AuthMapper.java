package com.berhan.mapper;

import com.berhan.dto.request.RegisterRequestDto;
import com.berhan.dto.request.UserProfileSaveRequestDto;
import com.berhan.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromDto(final RegisterRequestDto dto);

    @Mapping(source = "id",target = "authId")//source istenen kısım methoda dışardan girilen kısımdır.Target kısmı dönüştürlmek istenen kısım
    UserProfileSaveRequestDto fromAuth(final Auth auth);
}
