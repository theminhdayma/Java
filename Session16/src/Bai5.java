import java.util.ArrayList;
import java.util.Arrays;

public class Bai5 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 1, 3, 4, 6, 7, 8));
        ArrayList<Integer> checkedNumbers = new ArrayList<>();

        System.out.println("Số lần xuất hiện của từng phần tử:");
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (!checkedNumbers.contains(num)) {
                int count = 0;
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j) == num) {
                        count++;
                    }
                }
                System.out.println(num + " xuất hiện " + count + " lần.");
                checkedNumbers.add(num);
            }
        }
    }
}
