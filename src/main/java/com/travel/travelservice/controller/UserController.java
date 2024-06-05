package com.travel.travelservice.controller;

import com.travel.travelservice.dto.UserRequestDTO;
import com.travel.travelservice.dto.UserResponseDTO;
import com.travel.travelservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Long> join(@RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> findOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> users() {
        return ResponseEntity.ok(userService.findAll());
    }
}
