package Bai5;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(2),
                new Rectangle(3, 4),
                new Square(5)
        };

        for (Shape shape : shapes) {
            System.out.println("Diện tích: " + shape.area());
        }
    }
}

