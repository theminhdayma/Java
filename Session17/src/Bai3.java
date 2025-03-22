import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bai3 {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("Danh sách sau khi xóa các phần tử chẵn: " + numbers);
    }
}
