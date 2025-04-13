package Demo.business.service.statistic;

import Demo.business.dao.statistic.StatisticDao;
import Demo.business.dao.statistic.StatisticDaoImp;

import java.util.Map;

public class StatisticServiceImp implements StatisticService {
    private StatisticDao statisticDao;

    public StatisticServiceImp() {
        statisticDao = new StatisticDaoImp();
    }

    @Override
    public Map<String, Integer> getNumEmployeeOfDepartment() {
        return statisticDao.getNumEmployeeOfDepartment();
    }

    @Override
    public int getTotalEmployees() {
        return statisticDao.getTotalEmployees();
    }

    @Override
    public Map<String, Integer> maxEmployeeOfDepartment() {
        return statisticDao.maxEmployeeOfDepartment();
    }

    @Override
    public Map<String, Double> maxSalaryOfDepartment() {
        return statisticDao.maxSalaryOfDepartment();
    }
}

