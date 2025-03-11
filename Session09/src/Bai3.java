class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public void display() {
        System.out.println("Chiều dài: " + length + ", Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        rect1.display();

        Rectangle rect2 = new Rectangle(5.0, 3.5);
        rect2.display();
    }
}
