package com.testOTS.demo.demo.rest;

import com.testOTS.demo.demo.entity.Transactor;
import com.testOTS.demo.demo.service.TransactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TransactorRestController {

    private TransactorService transactorService;

    @Autowired
    public TransactorRestController(TransactorService transactorService) {
        this.transactorService = transactorService;
    }

    // expose "/transactors" and return list of transactors
    @GetMapping("/transactors")
    public List<Transactor> findAll() {
        return transactorService.findAll();
    }

    // add mapping for GET /transactors/{transactorId}

    @GetMapping("/transactors/{transactorId}")
    public Transactor getTransactor(@PathVariable long transactorId) {

        Transactor theTransactor = transactorService.findById(transactorId);

        if (theTransactor == null) {
            throw new RuntimeException("Transactor id not found - " + transactorId);
        }

        return theTransactor;
    }

    @GetMapping("/transactors/tin/{transactorTin}")
    public Transactor getTransactorTin(@PathVariable long transactorTin) {

        Transactor transactor = transactorService.findByTin(transactorTin);

        if(transactor == null) {
            throw new RuntimeException("Transactor not found");
        }

        return transactor;
    }

    // add mapping for POST /transactors - add new transactor

    @PostMapping("/transactors")
    public Transactor addTransactor(@RequestBody Transactor theTransactor) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theTransactor.setId(0);

        transactorService.save(theTransactor);

        return theTransactor;
    }

    // add mapping for PUT /transactors - update existing transactor

    @PutMapping("/transactors")
    public Transactor updateTransactor(@RequestBody Transactor theTransactor) {

        transactorService.save(theTransactor);

        return theTransactor;
    }

    // add mapping for DELETE /transactors/{transactorId} - delete transactor

    @DeleteMapping("/transactors/{transactorId}")
    public String deleteTransactor(@PathVariable long transactorId) {

        Transactor tempTransactor = transactorService.findById(transactorId);

        // throw exception if null

        if (tempTransactor == null) {
            throw new RuntimeException("Transactor id not found - " + transactorId);
        }

        transactorService.deleteById(transactorId);

        return "Deleted transactor id - " + transactorId;
    }
}
