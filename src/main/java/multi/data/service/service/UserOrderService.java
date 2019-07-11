package multi.data.service.service;


import multi.data.dao.model.primary.UserOrder;

import java.util.List;

public interface UserOrderService {
    UserOrder findUserOrder(Long id);

    List<UserOrder> findByUserId(Long id);

    List<UserOrder> findByTbId(String id);

    void deleteById(Long id);

    void deleteByUserId(Long id);

}
