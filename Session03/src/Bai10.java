import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();
        System.out.print("Nhập hệ số d: ");
        double d = scanner.nextDouble();

        if (a == 0) {
            solveQuadraticEquation(b, c, d);
        } else {
            solveCubicEquation(a, b, c, d);
        }

        scanner.close();
    }

    public static void solveQuadraticEquation(double b, double c, double d) {
        if (b == 0) {
            if (c == 0) {
                if (d == 0) {
                    System.out.println("Phương trình có vô số nghiệm.");
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            } else {
                System.out.println("Phương trình có một nghiệm: x = " + (-d / c));
            }
            return;
        }

        double delta = c * c - 4 * b * d;
        if (delta > 0) {
            double x1 = (-c + Math.sqrt(delta)) / (2 * b);
            double x2 = (-c - Math.sqrt(delta)) / (2 * b);
            System.out.println("Hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -c / (2 * b);
            System.out.println("Phương trình có nghiệm kép: x = " + x);
        } else {
            System.out.println("Phương trình vô nghiệm.");
        }
    }

    public static void solveCubicEquation(double a, double b, double c, double d) {

        double p = (3 * a * c - b * b) / (3 * a * a);
        double q = (2 * b * b * b - 9 * a * b * c + 27 * a * a * d) / (27 * a * a * a);
        double delta = (q * q / 4) + (p * p * p / 27);

        System.out.println("Giải phương trình: " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d + " = 0");

        if (delta > 0) {
            double u = Math.cbrt(-q / 2 + Math.sqrt(delta));
            double v = Math.cbrt(-q / 2 - Math.sqrt(delta));
            double x1 = u + v - (b / (3 * a));
            System.out.println("Một nghiệm thực duy nhất: x = " + x1);
        } else if (delta == 0) {
            double u = Math.cbrt(-q / 2);
            double x1 = 2 * u - (b / (3 * a));
            double x2 = -u - (b / (3 * a));
            System.out.println("Hai nghiệm thực: x1 = " + x1 + ", x2 = " + x2);
        } else {
            double r = Math.sqrt(-p * p * p / 27);
            double phi = Math.acos(-q / (2 * r));
            double x1 = 2 * Math.cbrt(r) * Math.cos(phi / 3) - (b / (3 * a));
            double x2 = 2 * Math.cbrt(r) * Math.cos((phi + 2 * Math.PI) / 3) - (b / (3 * a));
            double x3 = 2 * Math.cbrt(r) * Math.cos((phi + 4 * Math.PI) / 3) - (b / (3 * a));
            System.out.println("Ba nghiệm thực: x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
        }
    }
}
