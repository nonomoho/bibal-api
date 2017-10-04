package com.m2.miage.exemplaireOuevreService.boundary;

import com.m2.miage.exemplaireOuevreService.entity.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;


interface ExemplaireRepository extends JpaRepository<Exemplaire, String> {
}
