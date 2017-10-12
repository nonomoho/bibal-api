package com.m2.miage.empruntReservationService.boundary;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.m2.miage.empruntReservationService.entity.Emprunt;
import com.m2.miage.empruntReservationService.entity.EnumEmprunt;
import com.m2.miage.exemplaireOeuvreService.boundary.ExemplaireRepository;
import com.m2.miage.exemplaireOeuvreService.entity.Exemplaire;
import com.m2.miage.usagerService.boundary.UsagerRepository;
import com.m2.miage.usagerService.entity.Usager;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RepositoryRestController
public class EmpruntController {

  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final EmpruntRepository empr;
  private final ExemplaireRepository exr;
  private final UsagerRepository ur;

  @Autowired
  public EmpruntController(EmpruntRepository empr,
      ExemplaireRepository exr, UsagerRepository ur) {
    this.empr = empr;
    this.exr = exr;
    this.ur = ur;
  }

  @PostMapping(value = "/emprunts")
  public ResponseEntity<?> save(@RequestBody ObjectNode body) {
    List<Exemplaire> exemplairesDispos = exr.findAvailable(body.get("oeuvreId").asText());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate dateEmprunt = LocalDate.parse(body.get("dateEmprunt").asText(), formatter);
    Usager user = ur.findOne(body.get("usagerId").asText());
    Emprunt emprunt = new Emprunt(
        Date.valueOf(dateEmprunt),
        EnumEmprunt.EN_COURS,
        user,
        exemplairesDispos.get(0)
    );
    empr.save(emprunt);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
