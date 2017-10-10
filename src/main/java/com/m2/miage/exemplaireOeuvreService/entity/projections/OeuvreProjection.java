package com.m2.miage.exemplaireOeuvreService.entity.projections;

import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "OevreProjection", types = {Oeuvre.class})
public interface OeuvreProjection {

  String getId();

  String getTitre();

  String getAuteur();

  int getAnneeSortie();
}
