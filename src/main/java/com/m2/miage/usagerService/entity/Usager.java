package com.m2.miage.usagerService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Indexed
public class Usager {
    @Id
    private String id;
    @Field
    private String nom;
    @Field
    private String prenom;
    @Field
    private String adresse;
    @Field
    private String telephone;
}
