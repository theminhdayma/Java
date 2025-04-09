package business.service.account;

import business.model.Account;
import business.service.AppService;

public interface AccountService extends AppService {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);

    Account findAccountById(int id);

    double checkBalance(Account account);
}
