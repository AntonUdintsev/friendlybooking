package com.friendlybooking.mvp.monolit.dao;

import com.friendlybooking.mvp.monolit.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUserId(Long userId);

    List<Booking> findAllByMasterId(Long masterId);
}