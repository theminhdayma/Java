public class Bai8 {
    public static void main(String[] args) {
        double[] numbers = {8.8, 6.4, 7.2, 9.0, 8.2};
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double result = sum / numbers.length;
        System.out.println("Điểm trung bình: " + result);
    }
}
