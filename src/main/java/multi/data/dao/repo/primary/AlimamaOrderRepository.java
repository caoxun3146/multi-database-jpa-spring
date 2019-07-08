package multi.data.dao.repo.primary;


import multi.data.dao.model.primary.AlimamaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimamaOrderRepository extends JpaRepository<AlimamaOrder, Long> {
    AlimamaOrder findById(long id);

    AlimamaOrder findByOrderId(String id);
}
