package Bai5;

class SharedData {
    private String message;
    private boolean hasMessage = false;

    public synchronized void readMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reader nhận tin nhắn: " + message);
        hasMessage = false;
        notify();
    }

    public synchronized void writeMessage(String msg) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = msg;
        hasMessage = true;
        System.out.println("Writer gửi tin nhắn: " + msg);
        notify();
    }
}
