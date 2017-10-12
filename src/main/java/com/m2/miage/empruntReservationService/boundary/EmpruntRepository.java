package com.m2.miage.empruntReservationService.boundary;

import com.m2.miage.empruntReservationService.entity.Emprunt;
import com.m2.miage.empruntReservationService.entity.projections.EmpruntProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(excerptProjection = EmpruntProjection.class)
public interface EmpruntRepository extends CrudRepository<Emprunt, String> {

}
