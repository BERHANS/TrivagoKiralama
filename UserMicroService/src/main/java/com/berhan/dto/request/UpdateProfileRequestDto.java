package com.berhan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProfileRequestDto {
    String token;
    String email;
    String name;
    String photo;
    String phone;

}