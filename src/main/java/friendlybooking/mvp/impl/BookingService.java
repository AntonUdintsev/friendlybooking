package friendlybooking.mvp.impl;

import friendlybooking.mvp.dao.BookingRepository;
import friendlybooking.mvp.dao.MasterRepository;
import friendlybooking.mvp.dao.OperationRepository;
import friendlybooking.mvp.dao.UserRepository;
import friendlybooking.mvp.model.BookingRequest;
import friendlybooking.mvp.service.IBookingService;
import friendlybooking.mvp.service.ISmsService;
import friendlybooking.mvp.model.Booking;
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