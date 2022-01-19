package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.LançamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.services.EntryService;

import java.util.*;


@RestController
@RequestMapping("entry")
public class LancamentoController {

    @Autowired
    private EntryService service;
    @Autowired
    private LancamentoRepository repository;

    @GetMapping(path = {"/read"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LançamentoEntity>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(path = "/read/{id}")
    public LançamentoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public LançamentoEntity save(@RequestBody LançamentoEntity entity){
        return ResponseEntity.ok().body(service.save(entity)).getBody();
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<LançamentoEntity> update(@PathVariable("id") Long id, @RequestBody LançamentoEntity entry) {
        entry = service.update(entry);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = {"/read_paid"})
    public List findAllPaids() {
        return service.findByPaidTrue();
    }

    @GetMapping(path = {"/read_not_paid"})
    public List findAllNotPaids() {
        return service.findByPaidFalse();
    }


}

