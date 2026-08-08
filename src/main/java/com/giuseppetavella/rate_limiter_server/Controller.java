package com.giuseppetavella.rate_limiter_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class Controller {
    
    @GetMapping
    public String checkServerOk() {
        return "rate limiter - services simulator - server running";
    }

}
