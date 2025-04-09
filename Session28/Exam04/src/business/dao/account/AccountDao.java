package business.dao.account;

import business.dao.AppDao;
import business.model.Account;

public interface AccountDao extends AppDao {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
    Account findAccountById(int id);
    double checkBalance(Account account);
}
