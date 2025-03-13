class Employee {
    protected String name;
    protected String id;
    protected double salary;

    public Employee() {
        this.name = "Unknown";
        this.id = "000";
        this.salary = 0.0;
    }

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = Math.max(salary, 0);
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            this.salary += amount;
            System.out.println(name + " đã được tăng lương thêm " + amount);
        } else {
            System.out.println("Số tiền tăng lương không hợp lệ!");
        }
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", ID: " + id + ", Lương: " + salary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager() {
        super();
        this.bonus = 0.0;
    }

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = Math.max(bonus, 0); // Không cho phép tiền thưởng âm
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tiền thưởng: " + bonus;
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer() {
        super();
        this.programmingLanguage = "Unknown";
    }

    public Developer(String name, String id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage.isEmpty() ? "Unknown" : programmingLanguage;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ngôn ngữ lập trình: " + programmingLanguage;
    }
}

public class Bai9 {
    public static void main(String[] args) {
        Employee emp = new Employee("Nguyễn Thế Minh", "E001", 20000000);
        Manager mgr = new Manager("Trần Thị Huế", "M001", 10000000, 1000000);
        Developer dev = new Developer("Nguyễn Thị Hòa", "D001", 15000000, "Java");

        System.out.println("Thông tin nhân viên:");
        System.out.println(emp);
        System.out.println(mgr);
        System.out.println(dev);
        System.out.println();

        System.out.println("Lương của nhân viên: " + emp.getSalary());
        System.out.println("Lương của quản lý: " + mgr.getSalary());
        System.out.println("Lương của lập trình viên: " + dev.getSalary());
        System.out.println();

        emp.increaseSalary(1000000);
        System.out.println("Thông tin sau khi tăng lương:");
        System.out.println(emp);
    }
}
