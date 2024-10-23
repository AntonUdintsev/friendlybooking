package com.friendlybooking.mvp.monolit.dao;

import com.friendlybooking.mvp.monolit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber); // Поиск пользователя по номеру телефона

    boolean existsByPhoneNumber(String phoneNumber);
}
