package Bai8;

public class GasCar extends Car {
    public GasCar(String model, int year, double price) {
        super(model, year, price);
    }

    @Override
    public void start() {
        System.out.println("Xe chạy xăng " + toString() + " đã khởi động với tiếng động cơ.");
    }

    @Override
    public void stop() {
        System.out.println("Xe chạy xăng " + toString() + " đã dừng và động cơ tắt.");
    }

    @Override
    public void refuel() {
        System.out.println("Xe chạy xăng " + toString() + " đang được đổ xăng...");
    }
}
