import java.util.Scanner;
import java.util.HashMap;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            // Hiển thị menu chính
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Xử lý chuỗi");
            System.out.println("2. Xử lý số nguyên");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");
            mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1: {
                    String inputString = "";
                    int choice;
                    do {
                        System.out.println("\n===== MENU XỬ LÝ CHUỖI =====");
                        System.out.println("1. Nhập chuỗi");
                        System.out.println("2. Loại bỏ khoảng trắng thừa");
                        System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
                        System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn");
                        System.out.println("5. Quay lại menu chính");
                        System.out.print("Chọn chức năng (1-5): ");
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng thừa

                        switch (choice) {
                            case 1:
                                System.out.print("Nhập chuỗi: ");
                                inputString = scanner.nextLine();
                                break;
                            case 2:
                                inputString = inputString.replaceAll("\\s+", " ").trim();
                                System.out.println("Chuỗi sau khi loại bỏ khoảng trắng thừa: " + inputString);
                                break;
                            case 3:
                                HashMap<Character, Integer> charCount = new HashMap<>();
                                for (char c : inputString.toCharArray()) {
                                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                                }
                                System.out.println("Số lần xuất hiện của từng ký tự:");
                                for (char c : charCount.keySet()) {
                                    System.out.println(c + ": " + charCount.get(c));
                                }
                                break;
                            case 4:
                                String[] words = inputString.split("\\s+");
                                String formattedString = "";
                                for (String word : words) {
                                    formattedString += Character.toUpperCase(word.charAt(0)) +
                                            word.substring(1).toLowerCase() + " ";
                                }
                                inputString = formattedString.trim();
                                System.out.println("Chuỗi sau khi chuẩn hóa: " + inputString);
                                break;
                            case 5:
                                System.out.println("Quay lại menu chính...");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                        }
                    } while (choice != 5);
                    break;
                }
                case 2: {
                    int[] numbers = {};
                    int choice;
                    do {
                        System.out.println("\n===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====");
                        System.out.println("1. Nhập mảng số nguyên");
                        System.out.println("2. Tìm số nguyên tố lớn nhất");
                        System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
                        System.out.println("4. Kiểm tra mảng có đối xứng không");
                        System.out.println("5. Quay lại menu chính");
                        System.out.print("Chọn chức năng (1-5): ");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.print("Nhập số lượng phần tử: ");
                                int n = scanner.nextInt();
                                numbers = new int[n];
                                System.out.println("Nhập các phần tử của mảng:");
                                for (int i = 0; i < n; i++) {
                                    numbers[i] = scanner.nextInt();
                                }
                                break;
                            case 2:
                                int maxPrime = -1;
                                for (int num : numbers) {
                                    boolean isPrime = true;
                                    if (num < 2) isPrime = false;
                                    else {
                                        for (int i = 2; i * i <= num; i++) {
                                            if (num % i == 0) {
                                                isPrime = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (isPrime && num > maxPrime) {
                                        maxPrime = num;
                                    }
                                }
                                if (maxPrime == -1) {
                                    System.out.println("Không có số nguyên tố trong mảng.");
                                } else {
                                    System.out.println("Số nguyên tố lớn nhất trong mảng: " + maxPrime);
                                }
                                break;
                            case 3:
                                int countOddFirstDigit = 0;
                                for (int num : numbers) {
                                    int firstDigit = Integer.parseInt(Integer.toString(Math.abs(num)).substring(0, 1));
                                    if (firstDigit % 2 != 0) {
                                        countOddFirstDigit++;
                                    }
                                }
                                System.out.println("Số phần tử có chữ số đầu tiên là số lẻ: " + countOddFirstDigit);
                                break;
                            case 4:
                                boolean isSymmetric = true;
                                for (int i = 0; i < numbers.length / 2; i++) {
                                    if (numbers[i] != numbers[numbers.length - 1 - i]) {
                                        isSymmetric = false;
                                        break;
                                    }
                                }
                                System.out.println(isSymmetric ? "Mảng là mảng đối xứng." : "Mảng không phải là mảng đối xứng.");
                                break;
                            case 5:
                                System.out.println("Quay lại menu chính...");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                        }
                    } while (choice != 5);
                    break;
                }
                case 3:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        } while (mainChoice != 3);
        scanner.close();
    }
}
