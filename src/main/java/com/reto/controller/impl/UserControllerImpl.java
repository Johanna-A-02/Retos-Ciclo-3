package com.reto.controller.impl;

import com.reto.controller.UserSecurityAPI;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserControllerImpl  implements UserSecurityAPI {

    public Map<String, Object> user(OAuth2User principal){
        return Collections.singletonMap("name",principal.getAttribute("name"));
    }
}
