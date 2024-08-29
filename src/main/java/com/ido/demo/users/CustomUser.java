/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 *
 * @author HP
 */
@Entity
//@Table(name="users")
public class CustomUser {
    
   private @Id
   @GeneratedValue Long id;
   private Long contact_id;
   private String name;
   private String role;
   
   CustomUser(){};
   
   CustomUser(String name, String role){
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
}
