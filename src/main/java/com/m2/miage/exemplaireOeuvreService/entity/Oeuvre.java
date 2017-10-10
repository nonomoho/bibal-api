package com.m2.miage.exemplaireOeuvreService.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Indexed
public class Oeuvre {
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String titre;
    private String auteur;
    private int anneeSortie;
    @OneToMany(mappedBy = "oeuvre")
    private Set<Exemplaire> exemplaires;
}
