package com.friendlybooking.mvp.monolit.impl;

import com.friendlybooking.mvp.monolit.dao.BookingRepository;
import com.friendlybooking.mvp.monolit.dao.MasterRepository;
import com.friendlybooking.mvp.monolit.dao.OperationRepository;
import com.friendlybooking.mvp.monolit.dao.UserRepository;
import com.friendlybooking.mvp.monolit.model.Booking;
import com.friendlybooking.mvp.monolit.model.BookingRequest;
import com.friendlybooking.mvp.monolit.service.IBookingService;
import com.friendlybooking.mvp.monolit.service.ISmsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final ISmsService smsService;
    private final UserRepository userRepository;
    private final MasterRepository masterRepository;
    private final OperationRepository operationRepository;

    @Transactional
    public Booking createBooking(BookingRequest request) {
        // Логика создания бронирования: проверка доступности времени, создание записи
        Booking booking = new Booking();
        booking.setUser(userRepository.findByPhoneNumber(request.getPhoneNumber()).get());
        booking.setMaster(masterRepository.findById(request.getMasterId()).get());
        booking.setOperation(operationRepository.findById(request.getOperationId()).get());
        booking.setBookingTime(request.getBookingTime());
        booking.setStatus("CONFIRMED");

        // Отправка SMS подтверждения
        String code = smsService.generateCode();
        smsService.sendSms(request.getPhoneNumber(), "Ваш код для подтверждения записи: " + code);
        // Сохраняем запись
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findAllByUserId(userId);
    }

    public List<Booking> getMasterBookings(Long masterId) {
        return bookingRepository.findAllByMasterId(masterId);
    }
}