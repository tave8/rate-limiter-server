package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIResponsePayload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/email-api")
public class EmailAPIController {

    private final RestTemplate restTemplate;

    public EmailAPIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // @GetMapping
    // public String checkServerOk() {
    //     return "email API service works";
    // }
    
    @GetMapping
    public EmailAPIResponsePayload handleSendEmail() {
        return new EmailAPIResponsePayload("sdd");
    }

}
