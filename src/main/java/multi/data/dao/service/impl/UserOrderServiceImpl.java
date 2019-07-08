package multi.data.dao.service.impl;

import multi.data.dao.model.primary.UserOrder;
import multi.data.dao.repo.primary.UserOrderRepository;
import multi.data.dao.service.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    private final static Logger logger = LoggerFactory.getLogger(UserOrderServiceImpl.class);

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public UserOrder findUserOrder(Long id) {
        return userOrderRepository.findById(id).get();
    }

    @Override
    public List<UserOrder> findByTbId(String id) {
        List<UserOrder> userOrders = userOrderRepository.findByTbId(id);
        return userOrders;
    }

    @Override
    public List<UserOrder> findByUserId(Long id) {
        List<UserOrder> userOrders = userOrderRepository.findByUserId(id);
        return userOrders;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        UserOrder userOrder = userOrderRepository.findById(id).get();

        List<UserOrder> userOrders = userOrder.getAccount().getUserOrders();
        for (UserOrder userOrder1 : userOrders) {
            if (id.equals(userOrder1.getId())) {
                logger.info("userOrder1.getId() -------------------" + userOrder1.getId());
                userOrders.remove(userOrder1);
            }
        }

        userOrderRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByUserId(Long id) {
        UserOrder userOrder = userOrderRepository.findById(id).get();
        userOrder.clearUserOrder();
        ;
        userOrderRepository.deleteById(id);
    }


}
