package friendlybooking.mvp.service;

public interface ISmsService {
    void sendSms(String phoneNumber, String message);
    String generateCode();
}
