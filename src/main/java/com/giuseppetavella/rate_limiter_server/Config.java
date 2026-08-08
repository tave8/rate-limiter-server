package com.giuseppetavella.rate_limiter_server;

import com.giuseppetavella.rate_limiter_server.services.email_api.EmailAPIServiceLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false; // Tells RestTemplate that NO response is an error
            }
        });

        return restTemplate;
    }


    /**
     * Service limit for Email API.
     * 
     * @return
     * @throws IOException
     */
    @Bean
    public EmailAPIServiceLimiter loadEmailAPIServiceLimit() throws IOException {
        
        var objectMapper = new ObjectMapper();
        
        // Load service limit
        ClassPathResource resource = new ClassPathResource("service_limits/email_api.json");
        EmailAPIServiceLimiter serviceLimit;

        try (InputStream inputStream = resource.getInputStream()) {
            serviceLimit = objectMapper.readValue(
                    inputStream,
                    new TypeReference<EmailAPIServiceLimiter>() {}
            );
        }

        return serviceLimit;
    }

}