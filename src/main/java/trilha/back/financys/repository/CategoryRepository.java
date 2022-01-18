package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.entities.Category;

import java.util.ArrayList;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

    ArrayList<Category> findByName(String nameCategory);
}
