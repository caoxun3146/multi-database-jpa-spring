package multi.data.dao.repo.secondary;

import multi.data.dao.model.secondary.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findByPhoneId(String phoneId);
}
