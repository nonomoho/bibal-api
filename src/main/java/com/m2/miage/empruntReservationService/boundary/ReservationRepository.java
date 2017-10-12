package com.m2.miage.empruntReservationService.boundary;

import com.m2.miage.empruntReservationService.entity.Reservation;
import com.m2.miage.empruntReservationService.entity.projections.ReservationProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(excerptProjection = ReservationProjection.class)
public interface ReservationRepository extends CrudRepository<Reservation, String> {

}
