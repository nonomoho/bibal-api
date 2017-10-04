package com.m2.miage.exemplaireOuevreService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Indexed

public class Exemplaire {
    @Id
    private String exemplaire_id;
    @Enumerated
    private EnumExemplaire etat;
    private String oeuvre_id;
}
