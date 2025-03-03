import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        double num1 = sc.nextDouble();

        System.out.print("Nhập phép toán (+, -, *, /): ");
        char operation = sc.next().charAt(0);

        System.out.print("Nhập số thứ hai: ");
        double num2 = sc.nextDouble();

        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                System.out.println("Kết quả: " + num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Kết quả: " + num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Kết quả: " + num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Không thể chia cho 0.");
                } else {
                    result = num1 / num2;
                    System.out.println("Kết quả: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Phép toán không hợp lệ.");
        }

        sc.close();
    }
}
