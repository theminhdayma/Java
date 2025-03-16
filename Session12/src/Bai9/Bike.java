package Bai9;

class Bike extends Vehicle {
    @Override
    void move() {
        System.out.println("di chuyển với tốc độ chậm");
    }

    @Override
    void sound() {
        System.out.println("Ring Ring!");
    }
}

