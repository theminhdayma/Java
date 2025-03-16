package Bai3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mercedes-Benz", 300);
        Bike bike = new Bike("Ducati", 200);

        car.start();
        car.displayInfo();

        bike.start();
        bike.displayInfo();
    }
}

