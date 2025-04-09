package business.service.fundTransfer;

import business.dao.fundTransfer.FundTrsDao;
import business.dao.fundTransfer.FundTrsDaoImp;
import business.model.FundTransfer;

import java.time.LocalDate;
import java.util.List;

public class FundTrsServiceImp implements FundTrsService {
    private final FundTrsDao fundTrsDao;

    public FundTrsServiceImp() {
        fundTrsDao = new FundTrsDaoImp();
    }

    @Override
    public List<FundTransfer> getAllFundTransfer() {
        return fundTrsDao.getAllFundTransfers();
    }

    @Override
    public double totalMoney(LocalDate from, LocalDate to) {
        return fundTrsDao.totalMoney(from, to);
    }

    @Override
    public double getTotalMoneyByAccount(int accReceiverId) {
        return fundTrsDao.getTotalMoneyByAccount(accReceiverId);
    }

    @Override
    public int countSuccessedFundTransfer(LocalDate from, LocalDate to) {
        return fundTrsDao.countSuccessedFundTransfer(from, to);
    }
}
