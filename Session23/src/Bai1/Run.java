package Bai1;

public class Run extends Thread {
    @Override
    public void run() {
        System.out.println("Thread đang chạy: " + getName());
    }
}
