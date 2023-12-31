/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package groub2.backend.controller;

import groub2.backend.entities.Casher;
import groub2.backend.service.CasherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Ann
 */
@RestController
@RequestMapping("/api/casher")
public class CasherController {

    @Autowired
    CasherService casherService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Casher> listCasher() {
        return casherService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Casher> getCasher(@PathVariable Integer id) {
        Casher casher = casherService.getCasherById(id);
        if (casher != null) {
            return new ResponseEntity<>(casher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Casher> addCasher(@RequestBody Casher casher) {
        casher.setPassword(bCryptPasswordEncoder.encode(casher.getPassword()));
        casher.setRole("CASHER");
        casherService.addCasher(casher);
        return new ResponseEntity<>(casher, HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Casher> updateCasher(@PathVariable Integer id, @RequestBody Casher updatedCasher) {
//        Casher casher = casherService.getCasherById(id);
//        if (casher != null) {
//            updatedCasher.setId(id);
//            Casher updated = casherService.updateCasher(updatedCasher);
//            if (updated != null) {
//                return new ResponseEntity<>(updated, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/changePassword/{id}")
//    public ResponseEntity<Casher> changePassword(@PathVariable Integer id, @RequestBody Casher newPass) {
//        Casher casher = casherService.getCasherById(id);
//        if (casher != null) {
//            casher.setPassword(bCryptPasswordEncoder.encode(newPass.getPassword()));
//            casherService.changePassword(id, newPass,casher);
//            return new ResponseEntity<>(casher, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCasher(@PathVariable Integer id) {
        Casher casher = casherService.getCasherById(id);
        if (casher != null) {
            if (casher.getTaophieukhamCollection().isEmpty()) {
                casherService.deleteCasher(id);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
