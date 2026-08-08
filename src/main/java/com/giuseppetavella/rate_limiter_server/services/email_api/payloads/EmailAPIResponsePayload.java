package com.giuseppetavella.rate_limiter_server.services.email_api.payloads;

public class EmailAPIResponsePayload {
    private final String id;
    
    public EmailAPIResponsePayload(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
