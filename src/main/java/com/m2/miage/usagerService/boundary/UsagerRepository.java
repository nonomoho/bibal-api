package com.m2.miage.usagerService.boundary;

import com.m2.miage.usagerService.entity.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
interface UsagerRepository extends JpaRepository<Usager, String> {
}
