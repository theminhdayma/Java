class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public double dotProduct(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    public void displayVector() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3, 4);
        Vector2D v2 = new Vector2D(1, 2);

        System.out.print("Vector v1: ");
        v1.displayVector();
        System.out.print("Vector v2: ");
        v2.displayVector();

        System.out.println("Độ dài v1: " + v1.calculateMagnitude());
        System.out.println("Độ dài v2: " + v2.calculateMagnitude());

        Vector2D sum = v1.add(v2);
        System.out.print("v1 + v2 = ");
        sum.displayVector();

        Vector2D difference = v1.subtract(v2);
        System.out.print("v1 - v2 = ");
        difference.displayVector();

        System.out.println("Tích vô hướng (v1 · v2): " + v1.dotProduct(v2));
    }
}
