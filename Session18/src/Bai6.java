import java.util.*;

public class Bai6 {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new LinkedHashMap<>();

        studentScores.put("Nguyen Van A", 9);
        studentScores.put("Tran Thi B", 7);
        studentScores.put("Le Van C", 5);
        studentScores.put("Pham Thi D", 8);
        studentScores.put("Hoang Van E", 4);
        studentScores.put("Do Thi F", 6);
        studentScores.put("Bui Van G", 3);
        studentScores.put("Ngo Thi H", 10);
        studentScores.put("Dang Van I", 2);
        studentScores.put("Vu Thi J", 7);

        System.out.println("Danh sách học sinh và điểm số:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        double totalScore = 0;
        for (int score : studentScores.values()) {
            totalScore += score;
        }
        double averageScore = totalScore / studentScores.size();
        System.out.println("\nĐiểm trung bình của tất cả học sinh: " + averageScore);

        studentScores.entrySet().removeIf(entry -> entry.getValue() < 5);

        System.out.println("\nDanh sách học sinh sau khi xóa:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
