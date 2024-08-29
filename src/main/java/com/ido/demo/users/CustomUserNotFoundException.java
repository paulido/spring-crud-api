/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;

/**
 *
 * @author HP
 */
public class CustomUserNotFoundException extends RuntimeException {
    
    CustomUserNotFoundException(Long id){
        super("Could not found user " + id);
    }
    
}
