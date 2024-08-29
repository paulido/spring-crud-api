/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.contacts;

/**
 *
 * @author HP
 */
public class ContactNotFoundException extends RuntimeException {
    
    ContactNotFoundException(Long id){
        super("Could not found contact " + id);
    }
    
}
