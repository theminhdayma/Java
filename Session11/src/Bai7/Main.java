package Bai7;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Thế Minh", 30000),
                new PartTimeEmployee("Tuấn Anh", 25000, 4),
                new FullTimeEmployee("Đăng Thái", 20000),
                new PartTimeEmployee("Tần Hà", 30000, 5)
        };

        for (Employee emp : employees) {
            System.out.println("Nhân viên: " + emp.getName());
            System.out.println("Lương: " + emp.calculateSalary() + "VNĐ");
            System.out.println();
        }
    }
}
