package com.m2.miage.usagerService.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usager {

  @Id
  private UUID id = UUID.randomUUID();
  private String nom, prenon, adresse, telephone;
}
