package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LançamentoEntity;
import trilha.back.financys.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(path = {"/read"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoriaEntity>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }
    @GetMapping(path = {"/read/{id}"})
    public CategoriaEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public CategoriaEntity save(@RequestBody CategoriaEntity entity){
        return ResponseEntity.ok().body(service.save(entity)).getBody();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<LançamentoEntity> update(@PathVariable("id") Long id, @RequestBody CategoriaEntity category) {
        category = service.update(category);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }
}