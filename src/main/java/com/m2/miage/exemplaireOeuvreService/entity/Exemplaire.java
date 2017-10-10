package com.m2.miage.exemplaireOeuvreService.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Indexed
public class Exemplaire {
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Enumerated
    private EnumExemplaire etat;
    @ManyToOne
    private Oeuvre oeuvre;
}
