package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_algo.RateLimiter;
import com.giuseppetavella.rate_limiter_algo.RejectionReason;
import com.giuseppetavella.rate_limiter_algo.timeline.EventFilterer;
import com.giuseppetavella.rate_limiter_algo.timeline.RateLimiterSpeed;
import com.giuseppetavella.rate_limiter_algo.timeline.TimelineRateLimiter;
import org.springframework.stereotype.Service;

@Service
public class EmailAPIRateLimiter implements RateLimiter {

    private final TimelineRateLimiter limiter; // Rate Limiter implementation

    public EmailAPIRateLimiter(Builder builder) {
        this.limiter = new TimelineRateLimiter.Builder(builder.maxEvents, builder.window)
                .speed(builder.speed)
                .eventFilterer(builder.eventFilterer)
                .build();

        limiter.start(); // Remember to start the rate limiter
    }

    @Override
    public boolean add() {
        return limiter.add();
    }

    @Override
    public boolean canAdd() {
        return limiter.canAdd();
    }

    @Override
    public RejectionReason getRejectionReason() {
        return limiter.getRejectionReason();
    }


    public static class Builder {
        private int maxEvents;
        private long window;
        private RateLimiterSpeed speed;
        private EventFilterer eventFilterer;

        public Builder(int maxEvents, long window) {
            this.maxEvents = maxEvents;
            this.window = window;
        }

        public Builder speed(RateLimiterSpeed speed) {
            this.speed = speed;
            return this;
        }

        public Builder eventFilterer(EventFilterer fil) {
            this.eventFilterer = fil;
            return this;
        }

        public EmailAPIRateLimiter build() {
            return new EmailAPIRateLimiter(this);
        }

    }

}
