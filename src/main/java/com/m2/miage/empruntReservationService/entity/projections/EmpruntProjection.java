package com.m2.miage.empruntReservationService.entity.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2.miage.empruntReservationService.entity.Emprunt;
import com.m2.miage.empruntReservationService.entity.EnumEmprunt;
import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.usagerService.entity.Usager;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "emprunt", types = {Emprunt.class})
public interface EmpruntProjection {

  String getId();

  @JsonFormat(pattern = "yyyy-MM-dd")
  Date getDateEmprunt();

  @JsonFormat(pattern = "yyyy-MM-dd")
  Date getDateRetour();

  EnumEmprunt getEtat();

  Usager getUsager();

  Exemplaire getExemplaire();
}
