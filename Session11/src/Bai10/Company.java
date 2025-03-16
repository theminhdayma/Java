package Bai10;

public class Company {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Thế Minh", 10000),
                new Developer("Đăng Thái", 5000),
                new Developer("Tuấn Anh", 4500),
                new Manager("Quang", 9500),
                new Developer("Trần Hà", 5200)
        };

        System.out.println("\nCuộc họp đang diễn ra");
        for (Employee employee : employees) {
            if (employee instanceof AttendMeeting) {
                ((AttendMeeting) employee).attendMeeting();
            }
        }

        System.out.println("\nTrạng thái công việc");
        for (Employee employee : employees) {
            employee.work();
        }
    }
}