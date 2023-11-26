package com.berhan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/auth")
    public ResponseEntity<String> getFallbackAuth(){
        return ResponseEntity.ok("Auth micro servisi şu an hizmet vermemektedir. Lütfen daha sonra tekrar deneyin");
    }
    @GetMapping("/product")
    public ResponseEntity<String> getFallbackProduct(){
        return ResponseEntity.ok("Product micro servisi şu an hizmet vermemektedir. Lütfen daha sonra tekrar deneyin");
    }
    @GetMapping("/user")
    public ResponseEntity<String> getFallbackUser(){
        return ResponseEntity.ok("User micro servisi şu an hizmet vermemektedir. Lütfen daha sonra tekrar deneyin");
    }

}
