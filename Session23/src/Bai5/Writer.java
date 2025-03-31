package Bai5;

class Writer extends Thread {
    private final SharedData sharedData;

    public Writer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        String[] messages = {"Hey!", "Đang làm gì đấy", "Tao có đẹp trai không", "Thank you"};

        for (String msg : messages) {
            sharedData.writeMessage(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
