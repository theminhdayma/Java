package Bai3;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder()
                .setEngine("F1")
                .setSeats(4)
                .setColor("Trắng")
                .build();
        car1.showInfo();

        Car car2 = new Car.CarBuilder()
                .setEngine("F2")
                .setSeats(7)
                .setColor("Đen")
                .build();
        car2.showInfo();
    }
}

