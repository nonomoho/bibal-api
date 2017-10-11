package com.m2.miage.usagerService.entity.projections;

import com.m2.miage.usagerService.entity.Usager;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "usager", types = {Usager.class})
public interface UsagerProjection {

  String getId();

  String getNom();

  String getPrenom();

  String getAdresse();

  String getTelephone();
}
