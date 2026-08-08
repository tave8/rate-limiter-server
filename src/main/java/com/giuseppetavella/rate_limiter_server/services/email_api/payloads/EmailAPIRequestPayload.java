package com.giuseppetavella.rate_limiter_server.services.email_api.payloads;

public record EmailAPIRequestPayload(
        String recipient,
        String subject,
        String body
) {
}
