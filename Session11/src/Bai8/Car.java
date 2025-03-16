package Bai8;

public abstract class Car implements Refuelable {
    protected String model;
    protected int year;
    protected double price;

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    abstract void start();
    abstract void stop();

    public abstract void refuel();

    @Override
    public String toString() {
        return model + " (Năm SX: " + year + ", Giá: $" + price + ")";
    }
}
