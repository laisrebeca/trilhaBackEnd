package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.services.CategoriaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(path = {"/getAll"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoriaEntity>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }
    @GetMapping(path = {"/getAll/{id}"})
    public CategoriaEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody CategoriaEntity entity) {
        entity = service.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/updateById/{id}")
    public void updateById(@PathVariable Long id, @RequestBody CategoriaEntity entity) {
        service.updateById(entity);
        ResponseEntity.ok().body(entity);
    }
    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }
}