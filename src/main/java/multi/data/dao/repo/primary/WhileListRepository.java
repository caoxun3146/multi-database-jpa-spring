package multi.data.dao.repo.primary;

import multi.data.dao.model.primary.WhileList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface WhileListRepository extends JpaRepository<WhileList, Long> {
        WhileList findByKey(String key);

        @Transactional
        @Modifying
        WhileList save(WhileList whileList);
}
