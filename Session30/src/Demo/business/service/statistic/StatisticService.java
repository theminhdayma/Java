package Demo.business.service.statistic;

import java.util.Map;

public interface StatisticService {
    Map<String, Integer> getNumEmployeeOfDepartment();

    int getTotalEmployees();

    Map<String, Integer> maxEmployeeOfDepartment();

    Map<String, Double> maxSalaryOfDepartment();
}

