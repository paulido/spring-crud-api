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




/**
 *
 * @author HP
 */
@Configuration
public class LoadUsers {
  private static final Logger log = LoggerFactory.getLogger(LoadUsers.class);
  
  @Bean
  CommandLineRunner initUsers(CustomUserRepository repository){
    return args -> {
      log.info("Preloading " + repository.save(new CustomUser("user", "USER")));
      log.info("Preloading " + repository.save(new CustomUser("admin", "ADMIN")));
    }; 
  }
}
