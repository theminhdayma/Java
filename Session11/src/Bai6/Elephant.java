package Bai6;

public class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    void sound() {
        System.out.println("Trumpet!");
    }

    @Override
    void move() {
        System.out.println("The elephant is walking.");
    }
}
