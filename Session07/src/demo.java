import java.util.Scanner;
public class demo {
    public static String compressInputString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }
        StringBuilder compressedString = new StringBuilder();
        char currentCharacter = inputString.charAt(0);
        int characterCount = 1;
        for (int index = 1; index < inputString.length(); index++) {
            if (inputString.charAt(index) == currentCharacter) {
                characterCount++;
            } else {
                compressedString.append(currentCharacter).append(characterCount);
                currentCharacter = inputString.charAt(index);
                characterCount = 1;
            }
        }
        compressedString.append(currentCharacter).append(characterCount);
        return compressedString.toString();
    }
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Moi ban nhap:");
        String userInput = inputScanner.nextLine();
        String result = compressInputString(userInput);
        System.out.println( result);
        inputScanner.close();
    }
}