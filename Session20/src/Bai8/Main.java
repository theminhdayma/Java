package Bai8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Quý", "IT", 8.5),
                new Student("Lan", "Business", 7.2),
                new Student("Minh", "IT", 9.0),
                new Student("Huyền", "Design", 6.8),
                new Student("Long", "IT", 7.9),
                new Student("Trang", "Business", 8.1),
                new Student("Việt", "IT", 8.0),
                new Student("Tú", "Design", 7.5),
                new Student("Phúc", "Business", 6.9),
                new Student("An", "AI", 9.5)
        );

        Map<String, Long> majorCount = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));

        List<Map.Entry<String, Long>> sortedMajors = majorCount.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .toList();

        sortedMajors.forEach(entry ->
                System.out.printf("Chuyên ngành: %-10s | Số lượng: %d%n", entry.getKey(), entry.getValue()));
    }
}
