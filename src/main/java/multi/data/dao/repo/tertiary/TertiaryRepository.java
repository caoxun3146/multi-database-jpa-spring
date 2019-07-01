package multi.data.dao.repo.tertiary;

import multi.data.dao.model.tertiary.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TertiaryRepository extends JpaRepository<Balance, Long> {
    Balance findByUserId(int id);
}
