package Bai9;

class Airplane extends Vehicle {
    private int altitude;

    public Airplane(int altitude) {
        this.altitude = altitude;
    }

    @Override
    void move() {
        System.out.println("di chuyển trên không");
    }

    @Override
    void sound() {
        System.out.println("Whoosh!");
    }

    public int getAltitude() {
        return altitude;
    }
}
