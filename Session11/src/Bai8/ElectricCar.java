package Bai8;

public class ElectricCar extends Car {
    public ElectricCar(String model, int year, double price) {
        super(model, year, price);
    }

    @Override
    public void start() {
        System.out.println("Xe điện " + toString() + " đã khởi động không tiếng ồn.");
    }

    @Override
    public void stop() {
        System.out.println("Xe điện " + toString() + " đã dừng và ngắt kết nối động cơ.");
    }

    @Override
    public void refuel() {
        System.out.println("Xe điện " + toString() + " đang sạc điện...");
    }
}
