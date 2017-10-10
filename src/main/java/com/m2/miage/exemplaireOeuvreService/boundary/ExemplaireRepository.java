package com.m2.miage.exemplaireOeuvreService.boundary;

import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.exemplaireOeuvreService.entity.projections.ExemplaireProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(excerptProjection = ExemplaireProjection.class)
public interface ExemplaireRepository extends JpaRepository<Exemplaire, String> {

}
