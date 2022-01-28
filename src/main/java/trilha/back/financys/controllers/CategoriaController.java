package trilha.back.financys.controllers;

import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dto.CategoriaDto;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.services.CategoriaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    @ApiOperation(value = "Criar Categorias")
    public CategoriaEntity save(@RequestBody @Valid CategoriaDto dto){
        return service.save(dto);
    }

    @GetMapping(path = {"/getAll"})
    @ApiOperation(value = "Ler todas as Categorias")
    public List<CategoriaEntity>  getAll() {
        return ResponseEntity.ok().body(service.getAll()).getBody();
    }

    @GetMapping(path = "/getAll/{id}")
    @ApiOperation(value = "Ler as Categorias Através do ID")
    public CategoriaEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/updateById/{id}")
    @ApiOperation(value = "Atualiza as Categorias pelo ID")
    public ResponseEntity<CategoriaEntity> updateById(@PathVariable Long id,
                                                      @RequestBody @Valid CategoriaDto dto) {
       return ResponseEntity.ok().body(service.updateById(id, dto)).getBody();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deleta as Categorias pelo ID")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }


}