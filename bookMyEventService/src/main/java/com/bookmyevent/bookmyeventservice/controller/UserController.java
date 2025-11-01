package com.bookmyevent.bookmyeventservice.controller;

import com.bookmyevent.bookmyeventservice.dto.BookingDTO;
import com.bookmyevent.bookmyeventservice.entity.User;
import com.bookmyevent.bookmyeventservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}/bookings")
    public ResponseEntity<List<BookingDTO>> getUserBookings(@PathVariable Long userId) {
        List<BookingDTO> bookings = userService.getUserBookings(userId);
        return ResponseEntity.ok(bookings);
    }
}
