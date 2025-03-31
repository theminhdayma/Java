package Bai3;

class SharedResource {
    public synchronized void printAlphabet(String threadName) {
        System.out.println(threadName + ":");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println("\n");
    }
}
