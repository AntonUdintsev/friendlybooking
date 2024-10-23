package com.friendlybooking.mvp.monolit.service;

import com.friendlybooking.mvp.monolit.model.Booking;
import com.friendlybooking.mvp.monolit.model.BookingRequest;

import java.util.List;

public interface IBookingService {
    Booking createBooking(BookingRequest request);
    List<Booking> getUserBookings(Long userId);
    List<Booking> getMasterBookings(Long masterId);
}
