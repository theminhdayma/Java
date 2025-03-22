import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Bai2 {
    public static void main(String[] args) {
        Set<String> languages = new HashSet<>(
                Arrays.asList("Java", "Python", "C++", "JavaScript")
                        .stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.toSet())
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngôn ngữ cần kiểm tra: ");
        String input = scanner.nextLine().toLowerCase().trim();

        if (languages.contains(input)) {
            System.out.println("Chuỗi \"" + input + "\" có trong HashSet.");
        } else {
            System.out.println("Chuỗi \"" + input + "\" không có trong HashSet.");
        }

        scanner.close();
    }
}
