package trilha.back.financys.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.Entry;
import trilha.back.financys.repository.EntryRepository;
import trilha.back.financys.services.EntryService;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping("entry")
public class EntryController {

    @Autowired
    private EntryService service;
    @Autowired
    private EntryRepository repository;

    @GetMapping(path = {"/read"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Entry>> readAll() {
        return ResponseEntity.ok().body(service.readAll());
    }

    @GetMapping(path = "/read/{id}")
    public ResponseEntity<Entry> findById(@PathVariable("id") Long id) {
        Entry entry = service.findById(id);
        return ResponseEntity.ok(entry);

    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Entry> create(@RequestBody Entry entry) {
        if (service.validateCategoryById(entry.getCategoryId()) == true) {
            entry = service.createService(entry);
            return ResponseEntity.ok().body(entry);
        } else throw new ResourceNotFoundException("Id not exist");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Entry> update(@PathVariable("id") Long id, @RequestBody Entry entry) {
        service.update(entry, id);
        return ResponseEntity.ok(entry);
    }

    @GetMapping(path = {"/read_paid"})
    public List findAllPaids() {
        return repository.findByPaidTrue();
    }

    @GetMapping(path = {"/read_not_paid"})
    public List findAllNotPaids() {
        return repository.findByPaidFalse();
    }


}

