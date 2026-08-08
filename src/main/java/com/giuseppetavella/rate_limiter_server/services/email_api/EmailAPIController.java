package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_server.PayloadValidationHelper;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIRequestPayload;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIResponsePayload;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/email-api")
public class EmailAPIController {

    private final EmailAPIService emailAPIService;

    public EmailAPIController(EmailAPIService emailAPIService) {
        this.emailAPIService = emailAPIService;
    }

    // @GetMapping
    // public String checkServerOk() {
    //     return "email API service works";
    // }
    
    @PostMapping
    public EmailAPIResponsePayload handleSendEmail(
            @RequestBody @Validated EmailAPIRequestPayload payload,
            BindingResult validation) 
    {

        PayloadValidationHelper.requireNoErrors(validation);
        
        return emailAPIService.processEmailToSend(payload).join();
    }

}
