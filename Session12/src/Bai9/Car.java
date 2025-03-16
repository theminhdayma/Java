package Bai9;

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("di chuyển trên mặt đất.");
    }

    @Override
    void sound() {
        System.out.println("Vroom!");
    }
}
