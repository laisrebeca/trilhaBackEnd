package trilha.back.financys.services;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.CategoriaDto;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {
    private static final Logger log = LoggerFactory.logger(CategoriaService.class);
    @Autowired
    private final CategoriaRepository repository;
    @Autowired
    private final ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public CategoriaEntity save(CategoriaDto dto) {
        return repository.save(mapToEntity(dto));
    }

    public List<CategoriaEntity> getAll() {
        return ResponseEntity.ok().body(repository.findAll()).getBody();
    }
    public CategoriaEntity findById(Long id) {
        Optional<CategoriaEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            log.error("id could not be found");
        }
        return repository.getById(id);

    }

    public ResponseEntity<CategoriaEntity> updateById(Long id, CategoriaDto dto) {
        CategoriaEntity categoriaAtualizada = repository.findById(id).orElseThrow();
        categoriaAtualizada.setName(dto.getName());
        categoriaAtualizada.setDescription(dto.getDescription());
       return ResponseEntity.ok().body(repository.save(categoriaAtualizada));

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    private CategoriaEntity mapToEntity( CategoriaDto dto){
        return modelMapper.map(dto,CategoriaEntity.class );
    }

}


