package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.services.LacamentoService;

import java.net.URI;
import java.util.*;


@RestController
@RequestMapping("entry")
public class LancamentoController {

    @Autowired
    private LacamentoService service;
    @Autowired
    private LancamentoRepository repository;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LancamentoEntity>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(path = "/getAll/{id}")
    public LancamentoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody LancamentoEntity entity) {
        entity = service.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }

    @PutMapping(value = "/updateById/{id}")
    public void updateById(@PathVariable Long id, @RequestBody LancamentoEntity entity) {
        service.save(entity);
    }



}

