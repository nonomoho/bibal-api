package com.m2.miage.exemplaireOuevreService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Indexed
public class Oeuvre {
    @Id
    private String oeuvre_id;
    private String titre;
    private String auteur;
    private int anneeSortie;
    @ElementCollection
    @CollectionTable(name = "exemplaire", joinColumns = @JoinColumn(name = "oeuvre_id"))
    @Column(name = "exemplaire_id")
    private Set<String> exemplaires;
}
