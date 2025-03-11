class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Phương thức hiển thị thông tin
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }

    // Getter và Setter
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Phương thức tăng lương(increaseSalary(double percentage))
    public void increaseSalary(double percentage) {
        this.salary += this.salary * (percentage / 100);
    }
}


public class Bai2 {
    public static void main(String[] args) {
        Employee emp = new Employee(1, "Thế Minh", "IT", 5000);

        emp.displayInfo();
        emp.increaseSalary(10);
        System.out.println("After salary increase:");
        emp.displayInfo();
    }
}
