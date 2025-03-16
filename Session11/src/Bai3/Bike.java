package Bai3;

class Bike extends Vehicle {

    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Xe máy: " + name + ", Tốc độ: " + speed + " km/h");
    }
}