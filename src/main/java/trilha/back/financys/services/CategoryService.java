package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;



@Service
public class CategoryService {
    
    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaEntity> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    public CategoriaEntity findById(Long id){
        return repository.findById(id).get();
    }


    public CategoriaEntity save(CategoriaEntity entity) {
        return repository.save(entity);
    }

    public CategoriaEntity update(CategoriaEntity category){
        return repository.save(category);
    }


    public void deleteById(Long id){
        repository.deleteById(id);
    }

}

