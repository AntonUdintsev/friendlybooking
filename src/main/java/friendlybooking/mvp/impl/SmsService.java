package friendlybooking.mvp.impl;

import friendlybooking.mvp.service.ISmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class SmsService implements ISmsService {

    public void sendSms(String phoneNumber, String message) {
        // Используем сторонний сервис, например, Twilio для отправки SMS
        System.out.println("SMS to " + phoneNumber + ": " + message);
    }

    public String generateCode() {
        return String.valueOf(new Random().nextInt(8999) + 1000); // Генерация 4-значного кода
    }
}