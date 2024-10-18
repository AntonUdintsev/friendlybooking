package friendlybooking.mvp.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String password; // храним хэш пароля
    private String role = "USER_ROLE"; // роль пользователя

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
}