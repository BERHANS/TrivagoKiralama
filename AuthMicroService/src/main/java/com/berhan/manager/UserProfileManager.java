package com.berhan.manager;

import com.berhan.dto.request.UserProfileSaveRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Microservis yapısında servisleri bir birleri ile iletişime geçebilmeleri için kullanılan yapılardır.
 * Genellikle bir control yapısına istek atılır ve tüm end-pointleri interface içinde tanımlanır.
 * iki parametresi vardır;
 * 1- url: istek atılacak olan endpoint in adresi bulunur. root path buraya yazılır.(www.adres.com/userprofile gibi)
 * 2- name: her feignClient için benzersiz bir isimlendirme yapılır. İsim yazımı işlevselliğe göre verilir.
 */
@FeignClient(url = "${my-application.user-profile-end-point}",name = "userProfileManager")
public interface UserProfileManager {
    //Auth microservis user microservise ulaşmaya çalıştığı için bunu böyle tanımladık ve feign i buraya verdik

    @PostMapping("/save")
    ResponseEntity<Boolean> save (@RequestBody @Valid UserProfileSaveRequestDto dto);


}
