package multi.data.dao.repo.primary;

import multi.data.dao.model.primary.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);

    Account findByTbId(String tbId);

    Account findByPrdIdAndTbIdAndStatus(String prdId, String tbId, byte status);  // 注意两个以上条件时, 顺序不能弄反 ,否则查询出的结果为空
}