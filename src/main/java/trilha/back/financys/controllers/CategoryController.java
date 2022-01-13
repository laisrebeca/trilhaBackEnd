package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.Category;
import trilha.back.financys.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryRepository repository;

    @Autowired
    CategoryController (CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category){
        return repository.save(category);
    }
    @GetMapping(path = {"/read"})
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/read/{id}"})
    public Optional<Category> findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Category category) {
        return repository.findById(id)
                .map(record -> {
                    record.setId(category.getId());
                    record.setName(category.getName());
                    record.setDescription(category.getDescription());
                    Category updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);})
                    .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}