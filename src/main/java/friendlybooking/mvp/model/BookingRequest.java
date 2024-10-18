package friendlybooking.mvp.model;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BookingRequest {
    private Long userId;
    private LocalDateTime appointmentTime;
    private Long operationId;
    private String phoneNumber;
    private Long masterId;
    private LocalDateTime bookingTime;
    private String status; // "CONFIRMED", "CANCELLED"
}
