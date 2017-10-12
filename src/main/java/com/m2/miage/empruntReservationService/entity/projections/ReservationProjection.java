package com.m2.miage.empruntReservationService.entity.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2.miage.empruntReservationService.entity.EnumReservation;
import com.m2.miage.empruntReservationService.entity.Reservation;
import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import com.m2.miage.usagerService.entity.Usager;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "reservation", types = {Reservation.class})
public interface ReservationProjection {

  String getId();

  @JsonFormat(pattern = "yyyy-MM-dd")
  Date getDateReservation();

  EnumReservation getEtat();

  Usager getUsager();

  Oeuvre getOeuvre();
}
