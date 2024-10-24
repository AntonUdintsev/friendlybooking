package friendlybooking.mvp.dao;

import friendlybooking.mvp.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findById(Long Id);
}
