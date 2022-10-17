package com.reto.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@CrossOrigin(origins = "*")
public interface UserSecurityAPI {

    @GetMapping(value = "/user")
    Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal);
}
