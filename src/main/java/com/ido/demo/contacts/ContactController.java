/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.contacts;

/**
 *
 * @author HP
 */


import com.ido.demo.contacts.Contact;
import com.ido.demo.contacts.ContactNotFoundException;
import com.ido.demo.contacts.ContactRepository;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/api/v1")
public class ContactController {
    
  private final ContactRepository repository;
  
  ContactController(ContactRepository repository){
    this.repository = repository;
  }
  
  @GetMapping("/contacts")
  public List<Contact> all(){
      return this.repository.findAll();    
  }
  
  @PostMapping("/contacts")
  public Contact store(@RequestBody Contact contact){
    return this.repository.save(contact);
  }
  
  @GetMapping("/contacts/{id}")
  public Contact show(@PathVariable Long id){
    return this.repository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
  }
  
  @PutMapping("/contacts/{id}")
  public Contact update(@RequestBody Contact data, @PathVariable Long id){
    return this.repository.findById(id).map(contact -> {
      contact.setName(data.getName());
      contact.setPhone(data.getPhone());
      return this.repository.save(contact);
  }).orElseGet(() -> { return this.repository.save(data);});
  }
  
  @DeleteMapping("/contacts/{id}")
  public void delete(@PathVariable Long id){
      this.repository.deleteById(id);
  }
  
  
}

