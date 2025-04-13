package Demo.business.dao.statistic;

import java.util.Map;

public interface StatisticDao {
    Map<String, Integer> getNumEmployeeOfDepartment();

    int getTotalEmployees();

    Map<String, Integer> maxEmployeeOfDepartment();

    Map<String, Double> maxSalaryOfDepartment();
}
