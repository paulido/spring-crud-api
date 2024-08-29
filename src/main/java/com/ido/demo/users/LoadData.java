/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ido.demo.contacts.Contact;
import com.ido.demo.contacts.ContactRepository;



/**
 *
 * @author HP
 */
@Configuration
public class LoadData {
  private static final Logger log = LoggerFactory.getLogger(LoadData.class);
  
  @Bean
  CommandLineRunner initData(CustomUserRepository customUserRepository, ContactRepository contactRepository){
    return args -> {
        
      CustomUser user1 = new CustomUser("Dama", "USER");
      CustomUser user2 = new CustomUser("Athur", "USER");
      CustomUser user3 = new CustomUser("Paul", "ADMIN");
      
      customUserRepository.save(user1);
      customUserRepository.save(user2);
      customUserRepository.save(user3);
      
      Contact contact1 = new Contact("Inoussa", "inoussa@gmail.com", user1);
      Contact contact2 = new Contact("Inoussa", "inoussa@gmail.com", user2);
      Contact contact3 = new Contact("Inoussa", "inoussa@gmail.com", user3);
      
      contactRepository.save(contact1);
      contactRepository.save(contact2);
      contactRepository.save(contact3);
      
      log.info("Data preloaded");
    }; 
  }
}
