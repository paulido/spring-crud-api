/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ido.demo.users;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ido.demo.ResourceNotFoundException;
import java.util.Map;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/api/v1")
public class CustomUserController {

  private final CustomUserRepository repository;

  CustomUserController(CustomUserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/users")
  public List<CustomUser> all() {
    return this.repository.findAll();
  }

  @PostMapping("/users")
  public CustomUser store(@Valid @RequestBody CustomUser user) {
    return this.repository.save(user);
  }

  @GetMapping("/users/{id}")
  public CustomUser show(@PathVariable Long id) {
    return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
  }

  @PutMapping("/users/{id}")
  public CustomUser update(@Valid @RequestBody CustomUser data, @PathVariable Long id) {
    return this.repository.findById(id).map(user -> {
      user.setName(data.getName());
      user.setRole(data.getRole());
      return this.repository.save(user);
    }).orElseGet(() -> {
      return this.repository.save(data);
    });
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException();
    }
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
