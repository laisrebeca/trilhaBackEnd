package trilha.back.financys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.Category;
import trilha.back.financys.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;



@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll() {
        return new ArrayList<>(repository.findAll());
    }
    public long idCategoryByName(String nameCategory) {
        ArrayList<Category> result = repository.findByName(nameCategory);
        return result.isEmpty() ? 0 : result.get(0).getId();
    }
    public void save(Category category){
        repository.save(category);
    }
    public List<Category> findAll(){
        List<Category> category =repository.findAll();
        return category;
    }
    public Category findById(long id){
        return repository.findById(id).get();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}

