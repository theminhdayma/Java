package Bai9;

abstract class Vehicle {
    abstract void move();
    abstract void sound();

    public int move(int time, int speed) {
        return time * speed;
    }
}
