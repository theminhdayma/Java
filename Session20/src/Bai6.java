import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);

        Map<String, Long> itemCounts = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        System.out.println("Thời điểm xử lý: " + formattedDate);
        System.out.println(itemCounts);
    }
}
