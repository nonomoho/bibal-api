package com.m2.miage.empruntReservationService.boundary;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import com.m2.miage.empruntReservationService.entity.EnumReservation;
import com.m2.miage.empruntReservationService.entity.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RepositoryRestController
public class ReservationController {

  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final ReservationRepository rr;

  @Autowired
  public ReservationController(ReservationRepository rr) {
    this.rr = rr;
  }

  @PostMapping(value = "/reservations")
  public ResponseEntity<?> save(@RequestBody Reservation reservation) {
    reservation.setEtat(EnumReservation.EN_COURS);
    Reservation saved = rr.save(reservation);
    return ResponseEntity.created(linkTo(getClass()).slash(saved.getId()).toUri()).build();
  }
}
