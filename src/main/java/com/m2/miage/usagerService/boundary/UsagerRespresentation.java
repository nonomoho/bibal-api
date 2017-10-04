package com.m2.miage.usagerService.boundary;

import com.google.common.base.Strings;
import com.m2.miage.searchservice.boundary.SearchService;
import com.m2.miage.usagerService.entity.Usager;
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
@RequestMapping(value = "/usagers", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsagerRespresentation {

    private final UsagerRepository ur;
    private final SearchService ss;

    @Autowired
    public UsagerRespresentation(UsagerRepository ur, SearchService ss) {
        this.ur = ur;
        this.ss = ss;
    }

    //GET
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "q", required = false) String q) {
        List<Usager> usagers = Strings.isNullOrEmpty(q) ? ur.findAll() : ss.usagerSearch(q);
        return new ResponseEntity<>(usagers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        return Optional.ofNullable(ur.findOne(id))
                .map(usager -> new ResponseEntity<>(usager, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //POST
    @PostMapping
    public ResponseEntity<?> saveUsager(@RequestBody Usager usager) {
        usager.setId(UUID.randomUUID().toString());
        ur.save(usager);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUsager(@PathVariable("id") String id) {
        ur.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUsager(@RequestBody Usager usager, @PathVariable("id") String id) {
        Optional<Usager> body = Optional.ofNullable(usager);
        if (!body.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!ur.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usager.setId(id);
        ur.save(usager);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
