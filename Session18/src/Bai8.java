import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai8 {
    public static String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            while (num >= entry.getKey()) {
                roman.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        do {
            System.out.print("Nhập số phần tử của mảng: ");
            N = scanner.nextInt();
            if (N <= 0 || N > 3999) {
                System.out.println("Giá trị phải là số nguyên dương. Nhập lại");
            }
        } while (N <= 0 || N > 3999);

        System.out.println("Chữ số La Mã: " + intToRoman(N));

        scanner.close();
    }
}
