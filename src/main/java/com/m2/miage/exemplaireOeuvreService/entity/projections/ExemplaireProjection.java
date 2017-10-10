package com.m2.miage.exemplaireOeuvreService.entity.projections;

import com.m2.miage.exemplaireOeuvreService.entity.EnumExemplaire;
import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "exemplaire", types = {Exemplaire.class})
public interface ExemplaireProjection {

  String getId();

  EnumExemplaire getEtat();

  Oeuvre getOeuvre();
}
