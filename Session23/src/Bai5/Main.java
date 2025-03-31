package Bai5;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Writer writer = new Writer(sharedData);
        Reader reader = new Reader(sharedData);

        writer.start();
        reader.start();
    }
}

