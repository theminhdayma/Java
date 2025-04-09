package business.service.fundTransfer;

import business.model.FundTransfer;

import java.time.LocalDate;
import java.util.List;

public interface FundTrsService {
    List<FundTransfer> getAllFundTransfer();

    double totalMoney(LocalDate from, LocalDate to);

    double getTotalMoneyByAccount(int accReceiverId);

    int countSuccessedFundTransfer(LocalDate from, LocalDate to);
}
