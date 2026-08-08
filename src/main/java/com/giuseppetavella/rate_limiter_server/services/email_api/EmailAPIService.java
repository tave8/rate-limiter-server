package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIRequestPayload;
import com.giuseppetavella.rate_limiter_server.services.email_api.payloads.EmailAPIResponsePayload;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailAPIService {

    public CompletableFuture<EmailAPIResponsePayload> processEmailToSend(EmailAPIRequestPayload payload) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            var id = UUID.randomUUID();
            return new EmailAPIResponsePayload(id.toString());
        });
    }
    
}
