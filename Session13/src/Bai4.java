public class Bai4 {
    public static void main(String[] args) {
        String name = "Thế Minh";
        int age = 20;
        double[] scores = {7.5, 8.0, 6.5, 9.0, 8.5};

        generateReport(name, age, scores);
    }

    public static void generateReport(String name, int age, double[] scores) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        double avg = calculateAverage(scores);
        System.out.println("Average Score: " + avg);
        System.out.println("Grade: " + evaluateGrade(avg));
    }

    private static double calculateAverage(double[] scores) {
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }

    private static String evaluateGrade(double avg) {
        if (avg >= 8) {
            return "Excellent";
        } else if (avg >= 5) {
            return "Good";
        } else {
            return "Fail";
        }
    }
}
