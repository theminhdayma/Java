import java.util.ArrayList;
import java.util.Collections;

public class Bai3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        int maxNumber = Collections.max(numbers);
        int minNumber = Collections.min(numbers);

        System.out.println("Số nguyên lớn nhất: " + maxNumber);
        System.out.println("Số nguyên nhỏ nhất: " + minNumber);
    }
}
