package com.m2.miage.usagerService.boundary;

import com.m2.miage.usagerService.entity.Usager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
interface UsagerRepository extends CrudRepository<Usager, String> {

}
