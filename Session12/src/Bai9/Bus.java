package Bai9;

class Bus extends Vehicle {
    private int seats;

    public Bus(int seats) {
        this.seats = seats;
    }

    @Override
    void move() {
        System.out.println("di chuyển trên mặt đất");
    }

    @Override
    void sound() {
        System.out.println("Honk!");
    }

    public int getSeats() {
        return seats;
    }
}
