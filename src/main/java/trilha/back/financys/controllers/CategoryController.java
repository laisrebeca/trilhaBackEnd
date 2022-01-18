package trilha.back.financys.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.Category;
import trilha.back.financys.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService service;
    private Category category;

    @GetMapping(path = {"/read"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
    @GetMapping(path = {"/read/{id}"})
    public Category findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category body) {
        if(service.idCategoryByName(body.getName()) == 0){
            service.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category body){
        Category aux = service.findById(id);
        BeanUtils.copyProperties(body,aux,"id");
        service.save(aux);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}