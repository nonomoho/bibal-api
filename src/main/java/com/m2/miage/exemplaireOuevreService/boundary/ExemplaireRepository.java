package com.m2.miage.exemplaireOuevreService.boundary;

import com.m2.miage.exemplaireOuevreService.entity.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface ExemplaireRepository extends JpaRepository<Exemplaire, String> {
}
