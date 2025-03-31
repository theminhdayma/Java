package Bai6;

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1 (MIN_PRIORITY)");
        MyThread thread2 = new MyThread("Thread 2 (NORM_PRIORITY)");
        MyThread thread3 = new MyThread("Thread 3 (MAX_PRIORITY)");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
