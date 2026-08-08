package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_server.PayloadValidationHelper;
import com.giuseppetavella.rate_limiter_server.ServiceLimiter;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIRequestPayload;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIResponsePayload;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email-api")
public class EmailAPIController {

    private final EmailAPIService emailAPIService;
    private final ServiceLimiter serviceLimiter; // The limit for this service (Email API)
    
    public EmailAPIController(EmailAPIService emailAPIService, 
                              EmailAPIServiceLimiter emailAPIServiceLimiter) // Dependency injected
    {
        this.emailAPIService = emailAPIService;
        this.serviceLimiter = emailAPIServiceLimiter;
    }
    
    
    @PostMapping
    public EmailAPIResponsePayload handleSendEmail(
            @RequestBody @Validated EmailAPIRequestPayload payload,
            BindingResult validation) 
    {

        serviceLimiter.getHistory().add(); // Rate limit
        
        PayloadValidationHelper.requireNoErrors(validation);
        
        return emailAPIService.processEmailToSend(payload).join();
    }

}
