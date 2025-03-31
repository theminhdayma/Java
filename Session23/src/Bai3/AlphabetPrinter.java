package Bai3;

class AlphabetPrinter implements Runnable {
    private final SharedResource sharedResource;
    private final String threadName;

    public AlphabetPrinter(SharedResource sharedResource, String threadName) {
        this.sharedResource = sharedResource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        sharedResource.printAlphabet(threadName);
    }
}
