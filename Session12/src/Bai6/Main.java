package Bai6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Nguyễn Thế Minh", 20, 30000000, 2000000),
                new PartTimeEmployee("Trần Thị Mai", 25, 10000000, 20),
                new Intern("Bùi Thế Trường", 22, 15000000)
        };

        for (Employee emp : employees) {
            System.out.println("------------------------");
            emp.showInfo();
        }
    }
}

