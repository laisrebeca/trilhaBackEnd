package trilha.back.financys.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.DTO.CategoriaDTO;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private ModelMapper mapper;

    public List<CategoriaEntity> getAll() {
       return repository.findAll();
    }

    public CategoriaEntity findById(Long id){
        return repository.findById(id).get();
    }


    public CategoriaEntity save(CategoriaEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public ResponseEntity<CategoriaEntity> updateById(Long id,CategoriaDTO dto) {
        CategoriaEntity categoriaAtualizada = repository.findById(id).orElseThrow();
        categoriaAtualizada.setName(dto.getName());
        categoriaAtualizada.setDescription(dto.getDescription());
       return ResponseEntity.ok().body(repository.save(categoriaAtualizada));

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }


}


