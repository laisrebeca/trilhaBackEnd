package trilha.back.financys.services;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.ChartDto;
import trilha.back.financys.dto.LancamentoDto;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LacamentoService {
    private static final Logger log = LoggerFactory.logger(LacamentoService.class);
    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public LacamentoService(LancamentoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<LancamentoEntity> getAll() {
        return ResponseEntity.ok().body(repository.findAll()).getBody();
    }

    public LancamentoEntity findById(Long id) {
        Optional<LancamentoEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            log.error("id could not be found");
        }
        return repository.getById(id);

    }

    public List findByPaidTrue() {
        return repository.findByPaidTrue();
    }

    public List findByPaidFalse() {
        return repository.findByPaidFalse();
    }

    public LancamentoEntity save(LancamentoDto dto) {
        return repository.save(mapToEntity(dto));
    }

        public ResponseEntity<LancamentoEntity> updateById(Long id, LancamentoDto dto) {
       LancamentoEntity lacamentoAtualizada = repository.findById(id).orElseThrow();
        lacamentoAtualizada.setName(dto.getName());
        lacamentoAtualizada.setDescription(dto.getDescription());
        lacamentoAtualizada.setAmount(dto.getAmount());
        lacamentoAtualizada.setPaid(dto.getPaid());
        lacamentoAtualizada.setDate(dto.getDate());
        lacamentoAtualizada.setType(dto.getType());
        return ResponseEntity.ok().body(repository.save(lacamentoAtualizada));

    }

    public boolean categoriaById (Long idCategoria){
        return categoriaRepository.findById(idCategoria).isPresent();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<ChartDto> chartDto() {
        List<LancamentoEntity> listLancamento = repository.findAll();
        List<ChartDto> chartDtoList = new ArrayList<>();

        listLancamento.forEach(lancamento ->
            chartDtoList.stream().filter(retorno-> retorno.getNameChartDto().equals(lancamento.getName())).findAny()
            .ifPresentOrElse(
                    retorno -> {
                        retorno.setTotal(retorno.getTotal() + lancamento.getAmount());
                        },
                    () -> { chartDtoList.add(new ChartDto(lancamento.getName(), lancamento.getType(),lancamento.getAmount()));
                    }
            ));
        return chartDtoList;
    }

    private LancamentoEntity mapToEntity(LancamentoDto dto){
        return modelMapper.map(dto,LancamentoEntity.class );
    }

    private LancamentoDto mapToDto(LancamentoEntity lancamento) {
        return modelMapper.map(lancamento,LancamentoDto.class );
    }
}