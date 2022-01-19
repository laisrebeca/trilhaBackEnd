package trilha.back.financys.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.LançamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    private LancamentoRepository repository;


    public List<LançamentoEntity> getAll() {
        return new ArrayList<>(repository.findAll());
    }


    public LançamentoEntity findById(Long id) {
        Optional<LançamentoEntity> entity = repository.findById(id);
        return entity.get();
    }
    public LançamentoEntity save(LançamentoEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public LançamentoEntity update(LançamentoEntity entity) {
        return repository.save(entity);
    }

    public List findByPaidTrue() {
        return repository.findByPaidTrue();
    }

    public List findByPaidFalse() {
        return repository.findByPaidFalse();
    }
}