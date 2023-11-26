package com.berhan.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileSaveRequestDto {
    @Size(min = 3)
    String userName;
    Long authId;//iki servisi birleştirirken authId ile eşleştiririz
}
