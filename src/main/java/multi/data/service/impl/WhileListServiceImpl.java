package multi.data.service.impl;

import multi.data.dao.model.primary.WhileList;
import multi.data.dao.repo.primary.WhileListRepository;
import multi.data.service.service.WhileListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WhileListServiceImpl implements WhileListService {

    @Autowired
    private WhileListRepository whileListRepository;

    @Override
    public WhileList fingByKey(String key) {
        return whileListRepository.findByKey(key);
    }

    @Transactional
    @Modifying
    @Override
    public WhileList updateWhileList(WhileList whileList) {
        return whileListRepository.saveAndFlush(whileList);
       // return whileListRepository.save(whileList);
    }
}
