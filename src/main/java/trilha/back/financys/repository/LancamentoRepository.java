package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.entities.LançamentoEntity;

import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository <LançamentoEntity, Long> {

    List findByPaidTrue();

    List findByPaidFalse();
}
