package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trilha.back.financys.entities.Category;
import trilha.back.financys.entities.Entry;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository <Entry, Long> {

    List findByPaidTrue();

    List findByPaidFalse();
}
