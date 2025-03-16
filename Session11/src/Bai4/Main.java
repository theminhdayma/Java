package Bai4;

public class Main {
    public static void main(String[] args) {
        Electronic[] electronic = {
                new TV(),
                new Radio()
        };
        for (Electronic e : electronic) {
            e.turnOn();
            e.turnOff();
        }
    }
}
