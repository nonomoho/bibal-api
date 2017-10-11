package com.m2.miage.empruntReservationService.boundary;

import com.m2.miage.empruntReservationService.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
