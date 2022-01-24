package trilha.back.financys.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dto.CategoriaDto;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.services.CategoriaService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("category")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    public  CategoriaEntity save(@RequestBody CategoriaDto dto){
        return service.save(dto);
    }

    @GetMapping(path = {"/getAll"})
    public List<CategoriaEntity>  getAll() {
        return ResponseEntity.ok().body(service.getAll()).getBody();
    }

    @GetMapping(path = "/getAll/{id}")
    public CategoriaEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/updateById/{id}")
    public ResponseEntity<CategoriaEntity> updateById(@PathVariable Long id,
                                                      @RequestBody CategoriaDto dto) {
       return ResponseEntity.ok().body(service.updateById(id, dto)).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }


}