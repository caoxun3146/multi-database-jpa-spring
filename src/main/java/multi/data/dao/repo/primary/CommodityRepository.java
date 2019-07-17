package multi.data.dao.repo.primary;

import multi.data.dao.model.primary.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
        Commodity findBySourceId(String id);

}
