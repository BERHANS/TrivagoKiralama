package com.berhan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileResponseDto {

    String id;
    String userName;
    String email;
    String name;
    String photo;
    String phone;

}
