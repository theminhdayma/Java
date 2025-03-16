package Bai7;

abstract class Employee implements IEmployee {
    protected String name;
    protected double paymentPerHour;

    public Employee(String name, double paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public double getPaymentPerHour() {
        return paymentPerHour;
    }

    public abstract double calculateSalary();
}
