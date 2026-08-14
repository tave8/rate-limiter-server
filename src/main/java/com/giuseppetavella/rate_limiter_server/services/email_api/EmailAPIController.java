package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_algo.EventRejectedException;
import com.giuseppetavella.rate_limiter_algo.RateLimiter;
import com.giuseppetavella.rate_limiter_server.PayloadValidationHelper;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIRequestPayload;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIResponsePayload;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email-api")
public class EmailAPIController {

    private final EmailAPIService service;
    private final EmailAPIRateLimiter limiter; 
    
    public EmailAPIController(EmailAPIService service, 
                              EmailAPIRateLimiter limiter)
    {
        this.service = service;
        this.limiter = limiter;
    }
    
    
    @PostMapping
    public EmailAPIResponsePayload handleSendEmail(
            @RequestBody @Validated EmailAPIRequestPayload payload,
            BindingResult validation) 
    {

        // Rate limit
        if( !limiter.add() ) {
            throw new EventRejectedException(limiter);
        }
        
        PayloadValidationHelper.requireNoErrors(validation);
        
        return service.processEmailToSend(payload).join();
    }

}
