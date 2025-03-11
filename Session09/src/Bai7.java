class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        if (!hasRealRoots()) return Double.NaN;
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        if (!hasRealRoots()) return Double.NaN;
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public void display() {
        double delta = getDiscriminant();
        if (delta > 0) {
            System.out.println("Phương trình có hai nghiệm phân biệt:");
            System.out.println("x1 = " + getRoot1());
            System.out.println("x2 = " + getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có một nghiệm kép:");
            System.out.println("x = " + getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}

public class Bai7 {
    public static void main(String[] args) {
        QuadraticEquation equation1 = new QuadraticEquation(1, -3, 2);
        QuadraticEquation equation2 = new QuadraticEquation(1, -2, 1);
        QuadraticEquation equation3 = new QuadraticEquation(1, 1, 1);

        System.out.println("Phương trình 1: 1x^2 - 3x + 2 = 0");
        equation1.display();
        System.out.println("\nPhương trình 2: 1x^2 - 2x + 1 = 0");
        equation2.display();
        System.out.println("\nPhương trình 3: 1x^2 + 1x + 1 = 0");
        equation3.display();
    }
}
