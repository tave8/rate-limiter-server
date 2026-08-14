package com.giuseppetavella.rate_limiter_server;

public record RateLimiterInfo(
        int maxEvents,
        long window
) {
}
