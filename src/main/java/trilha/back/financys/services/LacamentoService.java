package trilha.back.financys.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LacamentoService {

    @Autowired
    private LancamentoRepository repository;


    public List<LancamentoEntity> getAll() {
        return new ArrayList<>(repository.findAll());
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

    public void updateById(LancamentoEntity entity) {
        repository.save(entity);
    }
}