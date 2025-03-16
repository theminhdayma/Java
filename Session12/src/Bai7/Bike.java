package Bai7;

class Bike extends Vehicle {
    @Override
    public void move() {
        System.out.println("Di chuyển chậm");
    }

    @Override
    public void sound() {
        System.out.println("Ring Ring");
    }
}

