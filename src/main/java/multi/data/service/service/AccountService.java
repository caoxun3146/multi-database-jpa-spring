package multi.data.service.service;


import multi.data.dao.model.primary.Account;

public interface AccountService {
    Account findById(Long id);

    void deleteById(Long id);

}
