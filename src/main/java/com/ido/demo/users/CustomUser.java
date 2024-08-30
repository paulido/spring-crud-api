/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ido.demo.contacts.Contact;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;
/**
 *
 * @author HP
 */
@Entity
@Table(name="users")
public class CustomUser {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private Long id;
   
   @NotBlank
   private String name;
   @NotBlank
   private String role;
   
   @OneToMany(mappedBy = "user") // user est le champ de contact qui contient le user du contact
   @JsonManagedReference // Sérialise la collection de contacts
    private Set<Contact> contacts;
   
   CustomUser(){};
   
   public CustomUser(String name, String role){
     this.name = name;
     this.role = role;
   }
   
   public Long getId(){
       return this.id;
   }
   
   public String getName(){
     return this.name;
   }
   
   public String getRole(){
     return this.role;
   }
   
   public void setId(Long id){
     this.id = id;
   }
   
   public void setName(String name){
     this.name = name;
   }
   
   public void setRole(String role){
     this.role = role;
   }
   
   public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
