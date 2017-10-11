package com.m2.miage.empruntReservationService.boundary;

import com.m2.miage.empruntReservationService.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, String> {

}
