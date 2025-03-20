import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai6 {
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer num : numbers) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6, 7, 3, 8, 9, 5, 10));

        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("Danh sách sau khi loại bỏ trùng lặp: " + uniqueNumbers);
    }
}
