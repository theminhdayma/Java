package Bai9;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus(40);
        Vehicle airplane = new Airplane(10000);

        car.move();
        car.sound();
        System.out.println("Ô tô di chuyển " + car.move(3, 60) + " km trong 3 giờ với tốc độ 60km/h");

        bike.move();
        bike.sound();
        System.out.println("Xe đạp di chuyển " + bike.move(1, 20) + " km trong 1 giờ với tốc độ 20km/h");

        bus.move();
        bus.sound();
        System.out.println("Xe bus có " + ((Bus) bus).getSeats() + " ghế ngồi và di chuyển " + bus.move(3, 50) + " km trong 3h với tốc độ 50km/h.");

        airplane.move();
        airplane.sound();
        System.out.println("Máy bay di chuyển " + airplane.move(5, 800) + " km trong 5 giờ với tốc độ 800km/h và cao " + ((Airplane) airplane).getAltitude() + "m.");
    }
}
