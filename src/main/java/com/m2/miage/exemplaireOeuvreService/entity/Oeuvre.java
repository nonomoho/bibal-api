package com.m2.miage.exemplaireOeuvreService.entity;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Oeuvre {

  @Id
  private UUID id = UUID.randomUUID();

  private String titre;
  private String auteur;
  private int anneeSortie;
  @OneToMany(mappedBy = "oeuvre")
  private Set<Exemplaire> exemplaires;

  @Override
  public String toString() {
    return String.format("%s %s %s", titre, auteur, anneeSortie);
  }
}
