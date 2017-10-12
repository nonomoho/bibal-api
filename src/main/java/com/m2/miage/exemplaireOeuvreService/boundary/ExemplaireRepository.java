package com.m2.miage.exemplaireOeuvreService.boundary;

import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.exemplaireOeuvreService.entity.projections.ExemplaireProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(excerptProjection = ExemplaireProjection.class)
public interface ExemplaireRepository extends CrudRepository<Exemplaire, String> {

  @Query("select e from Exemplaire e where e.oeuvre.id = ?1 AND e.id "
      + "NOT IN (select em.exemplaire.id from Emprunt em where em.exemplaire.id = e.id)")
  List<Exemplaire> findAvailable(@Param("oeuvreId") String oeuvreId);
}
