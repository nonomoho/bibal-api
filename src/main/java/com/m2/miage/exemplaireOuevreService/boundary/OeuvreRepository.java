package com.m2.miage.exemplaireOuevreService.boundary;

import com.m2.miage.exemplaireOuevreService.entity.Oeuvre;
import org.springframework.data.jpa.repository.JpaRepository;


interface OeuvreRepository extends JpaRepository<Oeuvre, String> {
}
