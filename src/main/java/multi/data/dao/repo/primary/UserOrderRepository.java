package multi.data.dao.repo.primary;


import multi.data.dao.model.primary.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByUserId(Long id);

    List<UserOrder> findByTbId(String id);

    void deleteById(Long id);

    void deleteByUserId(Long id);

}
