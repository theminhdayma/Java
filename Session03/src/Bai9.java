import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một số từ 100 đến 999: ");
        int number = scanner.nextInt();

        if (number < 100 || number > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            System.out.println(convertNumberToWords(number));
        }

        scanner.close();
    }

    public static String convertNumberToWords(int number) {
        String[] ones = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        String[] teens = {"mười", "mười một", "mười hai", "mười ba", "mười bốn", "mười lăm", "mười sáu", "mười bảy", "mười tám", "mười chín"};
        String[] tens = {"", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};

        int hundreds = number / 100;
        int remainder = number % 100;
        int tensDigit = remainder / 10;
        int units = remainder % 10;

        StringBuilder result = new StringBuilder();
        result.append(ones[hundreds]).append(" trăm");

        if (remainder == 0) {
            return result.toString();
        }

        if (tensDigit == 0 && units != 0) {
            result.append(" lẻ ").append(ones[units]);
        } else if (tensDigit == 1) {
            result.append(" ").append(teens[units]);
        } else {
            result.append(" ").append(tens[tensDigit]);
            if (units != 0) {
                if (units == 5) {
                    result.append(" lăm");
                } else {
                    result.append(" ").append(ones[units]);
                }
            }
        }

        return result.toString();
    }
}
