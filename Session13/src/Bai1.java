
public class Bai1 {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 10;
        int result = calculateExpression(number1, number2);
        System.out.println("Result: " + result);
    }

    public static int calculateExpression(int num1, int num2) {
        return num1 * num2 + (num1 + num2);
    }
}
