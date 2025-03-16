package Bai3;

class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Ô tô: " + name + ", Tốc độ: " + speed + " km/h");
    }
}
