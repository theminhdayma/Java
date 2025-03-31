package Bai3;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(new AlphabetPrinter(sharedResource, "Luồng 1"));
        Thread thread2 = new Thread(new AlphabetPrinter(sharedResource, "Luồng 2"));

        thread1.start();
        thread2.start();
    }
}

