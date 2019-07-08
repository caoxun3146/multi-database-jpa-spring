package multi.data.dao.service.impl;

import multi.data.dao.model.primary.AlimamaOrder;
import multi.data.dao.repo.primary.AlimamaOrderRepository;
import multi.data.dao.service.service.AlimamaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimamaOrderServiceImpl implements AlimamaOrderService {

    @Autowired
    AlimamaOrderRepository alimamaOrderRepository;

    @Override
    public AlimamaOrder findByOrderId(String id) {
        AlimamaOrder alimamaOrder = alimamaOrderRepository.findByOrderId(id);
        return alimamaOrder;
    }

    @Override
    public AlimamaOrder findById(long id) {
        AlimamaOrder alimamaOrder = alimamaOrderRepository.findById(id);
        return alimamaOrder;
    }

    @Override
    public void saveAlimamaOrder(AlimamaOrder alimamaOrder) {
        alimamaOrderRepository.save(alimamaOrder);
    }


}
