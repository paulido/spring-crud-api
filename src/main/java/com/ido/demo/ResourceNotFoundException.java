
package com.ido.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author HP
 */

 @ResponseStatus(HttpStatus.NOT_FOUND)
 public class ResourceNotFoundException extends RuntimeException {
 
     // Constructeur avec message
     public ResourceNotFoundException(String message) {
         super(message);
     }
 
     // Constructeur sans message, avec message par défaut
     public ResourceNotFoundException() {
         super("Ressource non trouvée.");
     }
 }
 