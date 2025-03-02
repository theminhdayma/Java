public class Bai4 {
    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;
        boolean c = true;

        boolean condition1 = a && b;
        boolean condition2 = a || b;
        boolean condition3 = !c;

        // Kiểm tra điều kiện
        if (a && b) {
            System.out.println("Cả hai đều đúng");
        }

        if (a || b) {
            System.out.println("Ít nhất một đúng");
        }

        if (!a && b) {
            System.out.println("Không đúng");
        }

        // Kiểm tra và đảo ngược giá trị của c
        System.out.println("Giá trị ban đầu của c: " + c);
        c = !c;
        System.out.println("Giá trị sau khi đảo ngược của c: " + c);

        // Kiểm tra biểu thức logic với toán tử ba ngôi (ternary operator)
        System.out.println(condition1 ? "Cả hai giá trị a và b đều đúng" : "Hoặc a sai hoặc b sai");
        System.out.println(condition2 ? "Trong a và b có ít nhất 1 giá trị đúng" : "Cả 2 giá trị a và b đều sai");
        System.out.println(condition3 ? "Phủ định của c là đúng" : "Phủ định của c là sai");

        // Kiểm tra biểu thức (a || b) && c sau khi đảo ngược c
        if ((a || b) && c) {
            System.out.println("Biểu thức (a || b) && c đúng");
        } else {
            System.out.println("Biểu thức (a || b) && c sai");
        }
    }
}
