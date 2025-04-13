package Demo.presentation.statistical;

import Demo.business.service.statistic.StatisticService;
import Demo.business.service.statistic.StatisticServiceImp;

import java.util.Map;
import java.util.Scanner;

public class StatisticUI {
    public static StatisticService statisticService = new StatisticServiceImp();
    public static void printMenuStatistic(Scanner sc) {
        StatisticUI statisticUI = new StatisticUI();
        do {
            System.out.println("-------------------THỐNG KÊ----------------");
            System.out.println("1. Số lượng nhân viên theo từng phòng ban");
            System.out.println("2. Tổng số nhân viên của toàn bộ hệ thống");
            System.out.println("3. Phòng ban có nhiều nhân viên nhất");
            System.out.println("4. Phòng ban có lương trung bình cao nhất");
            System.out.println("5. Trở về menu chính");
            System.out.printf("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    statisticUI.getCountEmployeeOfDepartment();
                    break;
                case 2:
                    statisticUI.getTotalEmployees();
                    break;
                case 3:
                    statisticUI.maxEmployeeOfDepartment();
                    break;
                case 4:
                    statisticUI.maxSalaryOfDepartment();
                    break;
                case 5:
                    System.out.println("Quay lại trang chủ");
                    return;
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 5!");
            }
        } while (true);
    }

    public void getCountEmployeeOfDepartment() {
        Map<String, Integer> countEmployeeOfDepartment = statisticService.getNumEmployeeOfDepartment();

        countEmployeeOfDepartment.forEach((key, value) -> {
            System.out.printf("%s: %d nhân viên\n", key, value);
        });
    }

    public void getTotalEmployees() {
        int totalEmployees = statisticService.getTotalEmployees();
        System.out.println("Tổng số nhân viên trong hệ thống là: " + totalEmployees);
    }

    public void maxEmployeeOfDepartment() {
        Map<String, Integer> maxEmployeeOfDepartment = statisticService.maxEmployeeOfDepartment();

        System.out.println("Các phòng ban có nhiều nhân viên nhất:");
        maxEmployeeOfDepartment.forEach((key, value) -> {
            System.out.printf("%s: %d nhân viên\n", key, value);
        });
    }

    public void maxSalaryOfDepartment() {
        Map<String, Double> maxSalaryOfDepartment = statisticService.maxSalaryOfDepartment();

        System.out.println("Phòng ban có lương trung bình cao nhất:");
        maxSalaryOfDepartment.forEach((key, value) -> {
            System.out.printf("%s: %.2f\n", key, value);
        });
    }
}