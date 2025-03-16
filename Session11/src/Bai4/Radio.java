package Bai4;

public class Radio implements Electronic {
    @Override
    public void turnOn() {
        System.out.println("Turning on Radio...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Radio...");
    }
}
