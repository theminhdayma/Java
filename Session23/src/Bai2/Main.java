package Bai2;

public class Main {
    public static void main(String[] args) {
        Run myRunnable = new Run();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
