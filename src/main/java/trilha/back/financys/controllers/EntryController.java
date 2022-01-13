package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.Entry;
import trilha.back.financys.repository.EntryRepository;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("entry")
public class EntryController {

    @Autowired
    private EntryRepository repository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Entry create(@RequestBody Entry entry){
        return repository.save(entry);
    }
    @GetMapping(path = {"/read_paid"})
    public List findAllPaids(){
        return repository.findByPaidTrue();
    }

    @GetMapping(path = {"/read_not_paid"})
    public List findAllNotPaids(){
        return repository.findByPaidFalse();
    }

    @GetMapping(path = {"/read"})
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/read/{id}"})
    public Optional<Entry> findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Entry entry) {
        return repository.findById(id)
                .map(record -> {
                    record.setId(entry.getId());
                    record.setName(entry.getName());
                    record.setDescription(entry.getDescription());
                    record.setType(entry.getType());
                    record.setAmount(entry.getAmount());
                    record.setDate(entry.getDate());
                    record.setPaid(entry.getPaid());
                    Entry updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);})
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}