package com.giuseppetavella.rate_limiter_server.services.email_api;

import com.giuseppetavella.rate_limiter_algo.timeline.RateLimiterSpeed;
import com.giuseppetavella.rate_limiter_server.RateLimiterInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class EmailAPIConfig {

    /**
     * Email API Rate Limiter.
     *
     * @return
     * @throws IOException
     */
    @Bean
    @Primary // Otherwise ambiguity with same class 
    public EmailAPIRateLimiter getEmailAPIRateLimiter(EmailAPIRateLimiter.Builder builder) throws IOException {
        return new EmailAPIRateLimiter(builder);
    }

    /**
     * Builder for Email API Rate Limiter.
     * 
     * @return
     * @throws IOException
     */
    @Bean
    public EmailAPIRateLimiter.Builder getEmailAPIRateLimiterBuilder() throws IOException {
        var objectMapper = new ObjectMapper();

        // Load rate limiter info
        ClassPathResource resource = new ClassPathResource("service_limits/email_api.json");
        RateLimiterInfo limiterInfo;

        try (InputStream inputStream = resource.getInputStream()) {
            limiterInfo = objectMapper.readValue(
                    inputStream,
                    new TypeReference<RateLimiterInfo>() {}
            );
        }
        
        return new EmailAPIRateLimiter.Builder(limiterInfo.maxEvents(), limiterInfo.window())
                .speed(RateLimiterSpeed.NORMAL);
    }
    
}
