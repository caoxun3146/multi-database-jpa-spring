package multi.data.service.service;


import multi.data.dao.model.primary.AlimamaOrder;

// AlimamaOrderRepostiory
public interface AlimamaOrderService {
    AlimamaOrder findByOrderId(String id);

    AlimamaOrder findById(long id);

    void saveAlimamaOrder(AlimamaOrder alimamaOrder);
}
