package multi.data.service.service;

import multi.data.dao.model.primary.Commodity;

public interface CommodityService {
    Commodity findCommodityInfo(String id);
}
