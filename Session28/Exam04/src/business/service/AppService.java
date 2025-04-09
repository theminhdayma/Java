package business.service;

import business.model.Account;

import java.util.List;

public interface AppService {
    List<Account> findAll();
    boolean add(Account account);

    boolean update(Account account);

    boolean delete(Account account);
}
