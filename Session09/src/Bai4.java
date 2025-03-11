class Circle {
    private double radius;

    public Circle() {
        this.radius = 10;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    public void display() {
        System.out.println("Bán kính: " + radius);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getCircumference());
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.display();

        Circle c2 = new Circle(12.5);
        c2.display();
    }
}
