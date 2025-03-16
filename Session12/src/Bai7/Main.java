package Bai7;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(),
                new Bike(),
                new Bus()
        };

        for (Vehicle v : vehicles) {
            System.out.println("------------------------");
            v.move();
            v.sound();
        }
    }
}

