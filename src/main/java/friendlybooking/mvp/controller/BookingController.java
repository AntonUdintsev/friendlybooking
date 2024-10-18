package friendlybooking.mvp.controller;

import friendlybooking.mvp.model.Booking;
import friendlybooking.mvp.model.BookingRequest;
import friendlybooking.mvp.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
