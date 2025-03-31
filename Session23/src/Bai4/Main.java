package Bai4;

public class Main {
    public static void main(String[] args) {
        NumberPrinter thread1 = new NumberPrinter();
        MessagePrinter thread2 = new MessagePrinter(thread1, "Thread 2");
        MessagePrinter thread3 = new MessagePrinter(thread1, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

