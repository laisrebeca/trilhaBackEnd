package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dto.LancamentoDto;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.services.LacamentoService;

import java.util.List;


@RestController
@RequestMapping("entry")
public class LancamentoController {

    @Autowired
    private LacamentoService service;

    @GetMapping("/getAll")
    public List<LancamentoEntity>  getAll() {
        return ResponseEntity.ok().body(service.getAll()).getBody();
    }

    @GetMapping(path = "/getAll/{id}")
    public LancamentoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public  LancamentoEntity save(@RequestBody LancamentoDto dto){
        return service.save(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }

    @PutMapping(value = "/updateById/{id}")
    public ResponseEntity<LancamentoEntity> updateById(@PathVariable Long id,
                                                        @RequestBody LancamentoDto dto) {
        return ResponseEntity.ok().body(service.updateById(id, dto)).getBody();
    }

}

