package business.dao.fundTransfer;

import business.model.FundTransfer;

import java.time.LocalDate;
import java.util.List;

public interface FundTrsDao{
    List<FundTransfer> getAllFundTransfers();

    double totalMoney(LocalDate from, LocalDate to);

    double getTotalMoneyByAccount(int accReceiverId);

    int countSuccessedFundTransfer(LocalDate from, LocalDate to);
}
