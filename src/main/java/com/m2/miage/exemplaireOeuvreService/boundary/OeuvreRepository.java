package com.m2.miage.exemplaireOeuvreService.boundary;

import com.m2.miage.exemplaireOeuvreService.entity.Oeuvre;
import com.m2.miage.exemplaireOeuvreService.entity.projections.OeuvreProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(excerptProjection = OeuvreProjection.class)
public interface OeuvreRepository extends JpaRepository<Oeuvre, String> {

}