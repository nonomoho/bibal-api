package com.m2.miage.empruntReservationService.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RepositoryRestController
public class ReservationController {

  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final ReservationRepository store;

  @Autowired
  public ReservationController(ReservationRepository store) {
    this.store = store;
  }

  @PostMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> save(@RequestBody Object reservation) {
    logger.info("POST", reservation);
    logger.info(String.valueOf(reservation));
    System.out.println("salut" + reservation);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
