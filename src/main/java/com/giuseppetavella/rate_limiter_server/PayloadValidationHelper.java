package com.giuseppetavella.rate_limiter_server;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Helper class for dealing with request payloads.
 * 
 * The methods in this class should always throw {@code PayloadValidationError},
 * at the very least.
 * 
 * <pre>{@code 
 *    
 *    PayloadValidationHelper.requiredPdf(file);
 *    
 *    PayloadValidationHelper.requireNoErrors(validation);
 * 
 * }</pre> 
 * 
 */
public class PayloadValidationHelper {
    
    /**
     * Helper when validating payloads.
     * Avoids having to check for errors manually, in each controller.
     * 
     * @throws PayloadValidationException if there's at least one error in the payload validation
     */
    public static void requireNoErrors(BindingResult validation) throws PayloadValidationException 
    {
        if (validation.hasErrors()) {
            List<String> errors = validation.getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList();
            throw new PayloadValidationException(errors);
        }
    }  
    
    
}