import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai7 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6, 7, 3, 8, 9, 5, 10, 3, 5));

        List<Integer> uniqueList = new ArrayList<>();

        List<Integer> duplicateList = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (Integer num : numbers) {
            int count = 0;
            for (Integer n : numbers) {
                if (num.equals(n)) count++;
            }
            if (count == 1) {
                uniqueList.add(num);
            } else if (count > 1 && !duplicateList.contains(num)) {
                duplicateList.add(num);
                counts.add(count);
            }
        }

        System.out.println("\nCác phần tử xuất hiện đúng một lần: " + uniqueList);

        System.out.println("\nCác phần tử bị trùng lặp kèm số lần xuất hiện:");
        for (int i = 0; i < duplicateList.size(); i++) {
            System.out.println(duplicateList.get(i) + " xuất hiện " + counts.get(i) + " lần");
        }
    }
}
