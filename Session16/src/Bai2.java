import java.util.ArrayList;
import java.util.Iterator;

public class Bai2 {
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

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 3 == 0) {
                iterator.remove();
            }
        }

        System.out.println("Danh sách sau khi xóa:");
        System.out.println(numbers);
    }
}
