package com.m2.miage.exemplaireOeuvreService.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Exemplaire {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

  @Enumerated
  private EnumExemplaire etat;
  @ManyToOne
  private Oeuvre oeuvre;

  @Override
  public String toString() {
    return String.format("%s %s", etat, oeuvre.getTitre());
  }
}
