package Bai4;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(3, 4);

        System.out.println("Diện tích hình tròn (Overriding): " + circle.area());
        System.out.println("Diện tích hình chữ nhật (Overriding): " + rectangle.area());

        System.out.println("Diện tích hình tròn (Overloading): " + shape.area(5));
        System.out.println("Diện tích hình chữ nhật (Overloading): " + shape.area(5, 10));
    }
}

