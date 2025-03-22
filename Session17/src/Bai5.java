import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bai5 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        Set<Integer> sortedSet = new TreeSet<>(unionSet);

        System.out.println("Hợp nhất và sắp xếp: " + sortedSet);
    }
}
