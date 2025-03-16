package Bai7;

class Bus extends Vehicle {
    @Override
    public void move() {
        System.out.println("Di chuyển với tốc độ trung bình");
    }

    @Override
    public void sound() {
        System.out.println("Honk Honk");
    }
}

