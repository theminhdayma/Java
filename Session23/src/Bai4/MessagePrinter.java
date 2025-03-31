package Bai4;

class MessagePrinter extends Thread {
    private final Thread threadToWait;

    public MessagePrinter(Thread threadToWait, String name) {
        super(name);
        this.threadToWait = threadToWait;
    }

    @Override
    public void run() {
        try {
            threadToWait.join();
            System.out.println(getName() + " bắt đầu...");
        } catch (InterruptedException e) {
            System.out.println(getName() + " bị gián đoạn!");
        }
    }
}
