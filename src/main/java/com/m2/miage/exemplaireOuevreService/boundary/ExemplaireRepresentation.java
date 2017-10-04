package com.m2.miage.exemplaireOuevreService.boundary;

import com.m2.miage.exemplaireOuevreService.entity.Exemplaire;
import com.m2.miage.exemplaireOuevreService.entity.Oeuvre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/exemplaires", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExemplaireRepresentation {
    private final ExemplaireRepository er;
    private final OeuvreRepository or;

    @Autowired
    public ExemplaireRepresentation(ExemplaireRepository er, OeuvreRepository or) {
        this.er = er;
        this.or = or;
    }


    //GET
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Exemplaire> exemplaires =  er.findAll();
        return new ResponseEntity<>(exemplaires, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        return Optional.ofNullable(er.findOne(id))
                .map(exemplaire -> new ResponseEntity<>(exemplaire, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //POST
    @PostMapping
    public ResponseEntity<?> saveExemplaire(@RequestBody Exemplaire exemplaire) {
        exemplaire.setExemplaire_id(UUID.randomUUID().toString());
        er.save(exemplaire);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteExemplaire(@PathVariable("id") String id) {
        er.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateExemplaire(@RequestBody Exemplaire exemplaire, @PathVariable("id") String id) {
        Optional<Exemplaire> body = Optional.ofNullable(exemplaire);
        if (!body.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!er.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        exemplaire.setExemplaire_id(id);
        er.save(exemplaire);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
