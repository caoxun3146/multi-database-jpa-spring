package multi.data.dao.service.service;

import multi.data.dao.model.primary.WhileList;

public interface WhileListService {
    WhileList fingByKey(String key);
    WhileList updateWhileList(WhileList whileList);
}
