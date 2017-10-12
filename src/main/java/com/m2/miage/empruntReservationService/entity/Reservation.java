package com.m2.miage.empruntReservationService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import com.m2.miage.usagerService.entity.Usager;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {

  @Id
  private UUID id = UUID.randomUUID();

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateReservation;

  private EnumReservation etat;

  @OneToOne
  private Usager usager;
  @OneToOne
  private Oeuvre oeuvre;
}
