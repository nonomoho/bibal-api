package com.m2.miage.exemplaireOeuvreService.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Oeuvre {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

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
