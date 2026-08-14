package com.giuseppetavella.rate_limiter_server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JitterUtilsTest {
    @Test
    void test1() {
        System.out.println(JitterUtils.addJitter(1000, .2));
        System.out.println(JitterUtils.addJitter(1000, .2));
        System.out.println(JitterUtils.addJitter(1000, .2));
        System.out.println(JitterUtils.addJitter(1000, .2));
        System.out.println(JitterUtils.addJitter(1000, .2));
        System.out.println(JitterUtils.addJitter(1000, .2));
        
    }
}