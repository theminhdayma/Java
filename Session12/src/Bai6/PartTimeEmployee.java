package Bai6;

class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee(String name, int age, double basicSalary, int hoursWorked) {
        super(name, age, basicSalary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return basicSalary * hoursWorked;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Số giờ làm việc: " + hoursWorked);
        System.out.println("Lương tổng: " + calculateSalary());
    }
}

