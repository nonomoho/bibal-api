package com.m2.miage.empruntReservationService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.usagerService.entity.Usager;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Emprunt {

  public Emprunt(LocalDate dateEmprunt, EnumEmprunt etat, Usager usager,
      Exemplaire exemplaire) {
    this.dateEmprunt = dateEmprunt;
    this.etat = etat;
    this.usager = usager;
    this.exemplaire = exemplaire;
  }

  @Id
  @Column(length = 36)

  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateEmprunt;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateRetour;

  private EnumEmprunt etat;

  @OneToOne
  private Usager usager;
  @OneToOne
  private Exemplaire exemplaire;
}
