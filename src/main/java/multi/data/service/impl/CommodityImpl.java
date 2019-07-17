package multi.data.service.impl;

import multi.data.dao.model.primary.Commodity;
import multi.data.dao.repo.primary.CommodityRepository;
import multi.data.service.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;
    @Override
    public Commodity findCommodityInfo(String id) {
        return commodityRepository.findBySourceId(id);
    }
}
