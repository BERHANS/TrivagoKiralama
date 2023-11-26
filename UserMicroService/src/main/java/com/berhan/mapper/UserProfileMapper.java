package com.berhan.mapper;

import com.berhan.dto.request.UserProfileSaveRequestDto;
import com.berhan.dto.response.UserProfileResponseDto;
import com.berhan.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {

    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfile fromDto(final UserProfileSaveRequestDto dto);

    UserProfileResponseDto toUserProfileResponseDto(final UserProfile userProfile);

}
