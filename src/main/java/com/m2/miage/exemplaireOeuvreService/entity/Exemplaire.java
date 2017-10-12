package com.m2.miage.exemplaireOeuvreService.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Exemplaire {

  @Id
  private UUID id = UUID.randomUUID();

  @Enumerated
  private EnumExemplaire etat;
  @ManyToOne
  private Oeuvre oeuvre;

  @Override
  public String toString() {
    return String.format("%s %s", etat, oeuvre.getTitre());
  }
}
