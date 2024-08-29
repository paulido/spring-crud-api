/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    
    
}
