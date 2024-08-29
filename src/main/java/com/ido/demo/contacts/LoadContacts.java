/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.contacts;
import com.ido.demo.users.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ido.demo.contacts.Contact;



/**
 *
 * @author HP
 */
@Configuration
public class LoadContacts {
  private static final Logger log = LoggerFactory.getLogger(LoadContacts.class);
  
  @Bean
  CommandLineRunner initContacts(ContactRepository repository){
    return args -> {
      log.info("Preloading " + repository.save(new Contact("Dama", "dama@gmail.com")));
      log.info("Preloading " + repository.save(new Contact("Arthur", "arthur@gmail.com")));
    }; 
  }
}
