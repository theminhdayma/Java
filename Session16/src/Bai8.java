import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bai8 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("dbsaj", "dkjslasda", "fdjs", "hjkfasdl", "jhkfsda", "jvkdjsa"));

        Collections.sort(stringList, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            return s1.compareTo(s2);
        });

        System.out.println("Danh sách sau khi sắp xếp: " + stringList);
    }
}
