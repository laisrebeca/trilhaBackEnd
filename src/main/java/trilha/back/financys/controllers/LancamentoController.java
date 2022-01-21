package trilha.back.financys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.services.LacamentoService;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("entry")
public class LancamentoController {

    @Autowired
    private LacamentoService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<LancamentoDTO>> getAll() {
        List<LancamentoEntity> list = service.getAll();
        List<LancamentoDTO> ListDto = list.stream().map(lancamentoEntity -> new LancamentoDTO(lancamentoEntity.getName(),
                lancamentoEntity.getDescription(),lancamentoEntity.getAmount(),lancamentoEntity.getDate(),lancamentoEntity.getPaid())).collect(Collectors.toList());
        return ResponseEntity.ok().body(ListDto);
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
    public ResponseEntity<LancamentoEntity> updateById(@PathVariable Long id,
                                                        @RequestBody LancamentoDTO dto) {
        return ResponseEntity.ok().body(service.updateById(id, dto)).getBody();
    }

}

