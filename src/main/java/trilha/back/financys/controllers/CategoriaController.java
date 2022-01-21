package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.services.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("category")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(path = {"/getAll"})
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        List<CategoriaEntity> list = service.getAll();
        List<CategoriaDTO> ListDto = list.stream().map(obj -> new CategoriaDTO(obj.getName(),
                obj.getDescription())).collect(Collectors.toList());
        return ResponseEntity.ok().body(ListDto);
    }

    @GetMapping(path = {"/findById/{id}"})
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
    public ResponseEntity<CategoriaEntity> updateById(@PathVariable Long id,
                                                      @RequestBody CategoriaDTO dto) {
       return ResponseEntity.ok().body(service.updateById(id, dto)).getBody();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }
}