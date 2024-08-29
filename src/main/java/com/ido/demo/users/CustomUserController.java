/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
public class CustomUserController {
    
  private final CustomUserRepository repository;
  
  CustomUserController(CustomUserRepository repository){
    this.repository = repository;
  }
  
  @GetMapping("/users")
  public List<CustomUser> all(){
      return this.repository.findAll();    
  }
  
  @PostMapping("/users")
  public CustomUser store(@RequestBody CustomUser user){
    return this.repository.save(user);
  }
  
  @GetMapping("/users/{id}")
  public CustomUser show(@PathVariable Long id){
    return this.repository.findById(id).orElseThrow(() -> new CustomUserNotFoundException(id));
  }
  
  @PutMapping("/users/{id}")
  public CustomUser update(@RequestBody CustomUser data, @PathVariable Long id){
    return this.repository.findById(id).map(user -> {
      user.setName(data.getName());
      user.setRole(data.getRole());
      return this.repository.save(user);
  }).orElseGet(() -> { return this.repository.save(data);});
  }
  
  @DeleteMapping("/users/{id}")
  public void delete(@PathVariable Long id){
      this.repository.deleteById(id);
  }
  
  
}
