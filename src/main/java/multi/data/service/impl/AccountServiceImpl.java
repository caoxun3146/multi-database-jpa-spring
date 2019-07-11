package multi.data.service.impl;

import multi.data.dao.model.primary.Account;
import multi.data.dao.repo.primary.AccountRepository;
import multi.data.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(Long id) {
        Account account = accountRepository.findById(id).get();
        return account;
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

}
