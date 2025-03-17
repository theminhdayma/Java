public class Bai3 {
    public static void main(String[] args) {
        Bai3 calculator = new Bai3();

        int a = 5;
        int b = 3;

        System.out.println("Tổng: " + calculator.add(a, b));
        System.out.println("Tích: " + calculator.multiply(a, b));
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
