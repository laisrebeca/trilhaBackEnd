package trilha.back.financys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.Category;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("/category")
public class CategoryController {
    private final List<Category> list = new ArrayList<>();

      @GetMapping("/read")
        public ResponseEntity<List<Category>> read() {
          return  ResponseEntity.ok().body(list);
      }


      @PostMapping("/create")
      public ResponseEntity<List<Category>> create(@RequestBody Category category) {
          Category category1 = new Category();
          category1.setId(category.getId());
          category1.setName(category.getName());
          category1.setDescription(category.getDescription());
          list.add(category1);
          return ResponseEntity.status(HttpStatus.CREATED).body(list);
      }


}
