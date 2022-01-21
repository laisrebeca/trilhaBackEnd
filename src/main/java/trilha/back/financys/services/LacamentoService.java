package trilha.back.financys.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.DTO.LancamentoDTO;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LacamentoService {

    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private ModelMapper mapper;


    public List<LancamentoEntity> getAll() {
            return repository.findAll();
        }


    public LancamentoEntity findById(Long id) {
        Optional<LancamentoEntity> entity = repository.findById(id);
        return entity.get();
    }

    public LancamentoEntity save(LancamentoEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ResponseEntity<LancamentoEntity> updateById(Long id, LancamentoDTO dto) {
       LancamentoEntity lacamentoAtualizada = repository.findById(id).orElseThrow();
        lacamentoAtualizada.setName(dto.getName());
        lacamentoAtualizada.setDescription(dto.getDescription());
        return ResponseEntity.ok().body(repository.save(lacamentoAtualizada));

    }
}