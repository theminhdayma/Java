import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đoạn văn bản:");
        String text = scanner.nextLine();
        scanner.close();

        String[] words = text.toLowerCase().split("\\W+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        List<String> sortedWords = new ArrayList<>(wordCount.keySet());
        Collections.sort(sortedWords);

        System.out.println("Danh sách từ và số lần xuất hiện:");
        for (String word : sortedWords) {
            System.out.println(word + ": " + wordCount.get(word));
        }
    }
}
