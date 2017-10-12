package com.m2.miage.empruntReservationService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.usagerService.entity.Usager;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emprunt {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateEmprunt;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateRetour;

  private EnumEmprunt etat;

  @OneToOne
  private Usager usager;

  @OneToOne
  private Exemplaire exemplaire;
}
