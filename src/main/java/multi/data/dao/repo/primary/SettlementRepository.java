package multi.data.dao.repo.primary;


import multi.data.dao.model.primary.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
    Settlement findById(long id);

    Settlement findByOrderId(String orderId);
}
