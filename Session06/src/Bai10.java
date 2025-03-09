import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đoạn văn bản: ");
        String inputText = scanner.nextLine();

        if (inputText.trim().isEmpty()) {
            System.out.printf("| %-30s | %-30s | %-20s |\n", inputText, "N/A");
            scanner.close();
            return;
        }

        String cleanedText = inputText.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase().trim().replaceAll("\\s+", " ");

        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher matcher = numberPattern.matcher(cleanedText);

        String numbersOutput = "[";
        boolean hasNumber = false;
        while (matcher.find()) {
            if (hasNumber) numbersOutput += ", ";
            numbersOutput += "\"" + matcher.group() + "\"";
            hasNumber = true;
        }
        numbersOutput += hasNumber ? "]" : "[]";

        System.out.printf("| %-30s | %-30s | %-20s |\n", inputText, "\"" + cleanedText + "\"", numbersOutput);

        scanner.close();
    }
}
