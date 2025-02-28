public class Bai4 {
    public static void main(String[] args) {
        // Khai báo và gán giá trị cho các biến boolean
        boolean a = true;
        boolean b = false;
        boolean c = true;

        if (a && b) {
            System.out.println("Cả hai đều đúng");
        }

        if (a || b) {
            System.out.println("Ít nhất một đúng");
        }

        if (!a && b) {
            System.out.println("Không đúng");
        }

        System.out.println("Giá trị ban đầu của c: " + c);
        c = !c;
        System.out.println("Giá trị sau khi đảo ngược của c: " + c);

        if ((a || b) && c) {
            System.out.println("Biểu thức (a || b) && c đúng");
        } else {
            System.out.println("Biểu thức (a || b) && c sai");
        }
    }
}
