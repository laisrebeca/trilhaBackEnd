package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
}
