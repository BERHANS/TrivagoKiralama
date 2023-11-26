package com.berhan.controller;

import com.berhan.dto.request.GetProfileByTokenRequestDto;
import com.berhan.dto.request.UpdateProfileRequestDto;
import com.berhan.dto.request.UserProfileSaveRequestDto;
import com.berhan.dto.response.UserProfileResponseDto;
import com.berhan.repository.entity.UserProfile;
import com.berhan.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.berhan.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserProfileController {

    private final UserProfileService service;

    @GetMapping("/getmessage")
    public String message(){
        return "Bu UserProfile Servistir";
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save (@RequestBody @Valid UserProfileSaveRequestDto dto){
        UserProfile userProfile = service.save(dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/get-profile")
    public ResponseEntity<UserProfileResponseDto> getProfileByToken(@RequestBody @Valid GetProfileByTokenRequestDto dto){
        return ResponseEntity.ok(service.getProfileByToken(dto));

    }
    @PostMapping("/update-profile")
    public ResponseEntity<Boolean> updateProfile(@RequestBody UpdateProfileRequestDto dto){
        return ResponseEntity.ok(service.updateProfile(dto));
    }
}
