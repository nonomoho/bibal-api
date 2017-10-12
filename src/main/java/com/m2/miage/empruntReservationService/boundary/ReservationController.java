package com.m2.miage.empruntReservationService.boundary;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import com.m2.miage.empruntReservationService.entity.EnumReservation;
import com.m2.miage.empruntReservationService.entity.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RepositoryRestController
@Slf4j
public class ReservationController {

  private final ReservationRepository rr;

  @Autowired
  public ReservationController(ReservationRepository rr) {
    this.rr = rr;
  }

  @PostMapping(value = "/reservations")
  public ResponseEntity<?> save(@RequestBody Reservation reservation) {
    reservation.setEtat(EnumReservation.EN_COURS);
    Reservation saved = rr.save(reservation);
    log.info("Saved reservation");
    return ResponseEntity.created(linkTo(getClass()).slash(saved.getId()).toUri()).build();
  }
}
