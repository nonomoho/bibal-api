package com.m2.miage.empruntReservationService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import com.m2.miage.usagerService.entity.Usager;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

  @Id
  @Column(length = 36)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateReservation;

  private EnumReservation etat;

  @OneToOne
  private Usager usager;
  @OneToOne
  private Oeuvre oeuvre;
}
