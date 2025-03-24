import java.util.HashMap;
import java.util.Map;

public class Bai1 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentScores = new HashMap<>();

        studentScores.put("Nguyen Thế Minh", 98);
        studentScores.put("Trần Huỳnh Như", 90);
        studentScores.put("Nguyễn Đắc Tùng", 78);
        studentScores.put("Phạm Tiến Hải", 92);

        System.out.println("Danh sách học sinh và điểm số:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String searchName = "Nguyen Van A";
        if (studentScores.containsKey(searchName)) {
            System.out.println("Điểm của " + searchName + ": " + studentScores.get(searchName));
        } else {
            System.out.println(searchName + " không có trong danh sách.");
        }
    }
}
