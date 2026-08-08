package com.giuseppetavella.rate_limiter_server.services.email_api.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EmailAPIRequestPayload(
        // Validators must go in this order: not null, not empty, email
        @NotNull(message = "Missing 'recipient' field.")
        @NotEmpty(message = "Field 'recipient' cannot be empty.")
        @Email(message = "Field 'recipient' must a valid email.")
        String recipient,
        
        @NotNull(message = "Missing 'subject' field.")
        @NotEmpty(message = "Field 'subject' cannot be empty.")
        String subject,

        @NotNull(message = "Missing 'body' field.")
        @NotEmpty(message = "Field 'body' cannot be empty.")
        String body
) {
}
