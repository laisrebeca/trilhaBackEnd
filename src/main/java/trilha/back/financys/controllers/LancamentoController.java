package trilha.back.financys.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dto.ChartDto;
import trilha.back.financys.dto.LancamentoDto;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.services.CategoriaService;
import trilha.back.financys.services.LacamentoService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("entry")
public class LancamentoController {

    @Autowired
    private LacamentoService service;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Ler todos os Lançamentos")
    public List<LancamentoEntity>  getAll() {
        return ResponseEntity.ok().body(service.getAll()).getBody();
    }

    @GetMapping(path = "/getAll/{id}")
    @ApiOperation(value = "Ler os Lançamentos Através do ID")
    public LancamentoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<?> findByName(@PathVariable String categoryName){
        Long categoria = categoriaService.CategoryByName(categoryName);
        return ResponseEntity.ok(categoria);
    }
    @GetMapping(path = {"/read_paid"})
    public List findAllPaids() {
        return service.findByPaidTrue();
    }

    @GetMapping(path = {"/read_not_paid"})
    public List findAllNotPaids() {
        return service.findByPaidFalse();
    }

    @PostMapping("/save")
    @ApiOperation(value = "Salva um Lançamento")
    public LancamentoEntity save(@RequestBody @Valid LancamentoDto dto){
        return service.save(dto);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deleta a Lançamento Pelo ID")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
        ResponseEntity.status(HttpStatus.OK).body(id).getBody();
    }

    @PutMapping(value = "/updateById/{id}")
    @ApiOperation(value = "Atualiza o Lançamento pelo ID")
    public ResponseEntity<LancamentoEntity> updateById(@PathVariable Long id, @RequestBody @Valid LancamentoDto dto) {
        return ResponseEntity.ok().body(service.updateById(id, dto)).getBody();
    }

    @GetMapping(path = "/ChartDto")
    public List<ChartDto> chartDto(){
            return service.chartDto();
        }

}

