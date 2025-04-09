package business.dao;

import business.model.Account;

import java.util.List;

public interface AppDao {
    List<Account> findAll();
    boolean add(Account account);
    boolean update(Account account);
    boolean delete(Account account);
}
