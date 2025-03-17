public class Bai2 {
    public static void main(String[] args) {
        double[] scores = {7.5, 8.0, 6.5};
        double averageScore = calculateAverage(scores);

        if (averageScore >= 5) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
}
