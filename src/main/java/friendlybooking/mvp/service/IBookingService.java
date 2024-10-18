package friendlybooking.mvp.service;

import friendlybooking.mvp.model.Booking;
import friendlybooking.mvp.model.BookingRequest;

import java.util.List;

public interface IBookingService {
    Booking createBooking(BookingRequest request);
    List<Booking> getUserBookings(Long userId);
    List<Booking> getMasterBookings(Long masterId);
}
