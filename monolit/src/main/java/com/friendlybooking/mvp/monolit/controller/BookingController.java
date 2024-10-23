package com.friendlybooking.mvp.monolit.controller;

import com.friendlybooking.mvp.monolit.model.Booking;
import com.friendlybooking.mvp.monolit.model.BookingRequest;
import com.friendlybooking.mvp.monolit.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final IBookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest request) {
        bookingService.createBooking(request);
        return ResponseEntity.ok("Booking created successfully!");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }

    @GetMapping("/master/{masterId}")
    public ResponseEntity<List<Booking>> getMasterBookings(@PathVariable Long masterId) {
        return ResponseEntity.ok(bookingService.getMasterBookings(masterId));
    }
}
