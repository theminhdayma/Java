import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bai1 {
    public static void main(String[] args) {
        List<String> strings = List.of("Java", "", "Lambda", "Stream", "", "Functional");

        Predicate<String> isNotEmpty = s -> !s.isEmpty();

        List<String> filteredStrings = strings.stream()
                .filter(isNotEmpty)
                .collect(Collectors.toList());

        System.out.println(filteredStrings);
    }
}
