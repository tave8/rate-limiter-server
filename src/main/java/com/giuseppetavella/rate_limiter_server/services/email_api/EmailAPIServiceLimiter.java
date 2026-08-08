package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_server.ServiceLimiter;

/**
 * Subclassing is only so that type system matches a service.
 */
public class EmailAPIServiceLimiter extends ServiceLimiter {
    
    public EmailAPIServiceLimiter(int maxEvents, long window) {
        super(maxEvents, window);
    }
}
