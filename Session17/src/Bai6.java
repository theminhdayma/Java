import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bai6 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30, 40));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(30, 40, 50, 60));

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        Set<Integer> sortedSet = new TreeSet<>(intersectionSet);

        System.out.println("Giao nhau và sắp xếp: " + sortedSet);
    }
}
