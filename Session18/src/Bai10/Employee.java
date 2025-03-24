package Bai10;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void displayInfo() {
        System.out.println("----------------------------------");
        System.out.println("ID: " + this.id);
        System.out.println("Tên nhân viên: " + this.name);
        System.out.println("Lương: " + this.salary);
    }
}

