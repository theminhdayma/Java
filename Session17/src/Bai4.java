import java.util.Arrays;
import java.util.TreeSet;
import java.util.Set;

public class Bai4 {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(Arrays.asList(45, 12, 78, 34, 23, 89));

        System.out.println("Các phần tử trong TreeSet: " + numbers);
    }
}
