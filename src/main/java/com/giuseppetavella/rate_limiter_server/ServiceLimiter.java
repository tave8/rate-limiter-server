package com.giuseppetavella.rate_limiter_server;


import com.giuseppetavella.rate_limiter_algo.RateLimiter;
import com.giuseppetavella.rate_limiter_algo.timeline.TimelineManager;

public class ServiceLimiter {
    private final int maxEvents;
    private final long window;
    private final RateLimiter limiter;
    
    public ServiceLimiter(int maxEvents, long window) {
        this.maxEvents = maxEvents;
        this.window = window;
        this.limiter = new TimelineManager(maxEvents, window);
    }

    public RateLimiter getLimiter() {
        return limiter;
    }

    public int getMaxEvents() {
        return maxEvents;
    }

    public long getWindow() {
        return window;
    }

    @Override
    public String toString() {
        return "ServiceLimit{" +
                "limiter=" + limiter +
                ", maxEvents=" + maxEvents +
                ", window=" + window +
                '}';
    }
}
