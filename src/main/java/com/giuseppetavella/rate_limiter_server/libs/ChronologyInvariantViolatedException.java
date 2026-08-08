package com.giuseppetavella.rate_limiter_server.libs;

public class ChronologyInvariantViolatedException extends RuntimeException {
    public ChronologyInvariantViolatedException() {
        super("Chronology invariant violated.");
    }
}
