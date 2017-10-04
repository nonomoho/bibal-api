package com.m2.miage.exemplaireOuevreService.boundary;


import com.m2.miage.exemplaireOuevreService.entity.Exemplaire;
import com.m2.miage.exemplaireOuevreService.entity.Oeuvre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/oeuvres", produces = MediaType.APPLICATION_JSON_VALUE)
public class OeuvreRepresentation {
    private final OeuvreRepository or;
    private final ExemplaireRepository er;

    @Autowired
    public OeuvreRepresentation(OeuvreRepository or, ExemplaireRepository er) {
        this.or = or;
        this.er = er;
    }


    //GET
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Oeuvre> oeuvres = or.findAll();
        return new ResponseEntity<>(oeuvres, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") String id) {
        return Optional.ofNullable(or.findOne(id))
                .map(oeuvre -> new ResponseEntity<>(oeuvre, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //POST
    @PostMapping
    public ResponseEntity<?> saveOeuvre(@RequestBody Oeuvre oeuvre) {
        oeuvre.setOeuvre_id(UUID.randomUUID().toString());
        or.save(oeuvre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOeuvre(@PathVariable("id") String id) {
        or.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOeuvre(@RequestBody Oeuvre oeuvre, @PathVariable("id") String id) {
        Optional<Oeuvre> body = Optional.ofNullable(oeuvre);
        if (!body.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!or.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oeuvre.setOeuvre_id(id);
        or.save(oeuvre);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
