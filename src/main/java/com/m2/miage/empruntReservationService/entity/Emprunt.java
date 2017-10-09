package com.m2.miage.empruntReservationService.entity;

import com.m2.miage.exemplaireOuevreService.entity.Exemplaire;
import com.m2.miage.usagerService.entity.Usager;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Indexed
public class Emprunt {
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Date dateEmprunt;
    private Date dateRetour;
    @OneToOne
    private Usager usager;
    @OneToOne
    private Exemplaire exemplaire;
}
