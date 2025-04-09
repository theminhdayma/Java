package business.service.account;

import business.dao.account.AccountDao;
import business.dao.account.AccountDaoImp;
import business.model.Account;

import java.util.List;

public class AccountServiceImp implements AccountService {
    private final AccountDao accountDao;

    public AccountServiceImp() {
        accountDao = new AccountDaoImp();
    }

    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        return accountDao.fundsTransfer(accSenderId, accSenderName, accReceiverId, accReceiverName, amount);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public double checkBalance(Account account) {
        return accountDao.checkBalance(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public boolean add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public boolean update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public boolean delete(Account account) {
        return accountDao.delete(account);
    }
}
