package com.giuseppetavella.rate_limiter_server;

import com.giuseppetavella.rate_limiter_server.libs.HistoryQueue;

public class ServiceLimiter {
    private final int maxEvents;
    private final long window;
    private final HistoryQueue history;
    
    public ServiceLimiter(int maxEvents, long window) {
        this.maxEvents = maxEvents;
        this.window = window;
        this.history = new HistoryQueue(maxEvents, window);
    }

    public HistoryQueue getHistory() {
        return history;
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
                "history=" + history +
                ", maxEvents=" + maxEvents +
                ", window=" + window +
                '}';
    }
}
