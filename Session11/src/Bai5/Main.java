package Bai5;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Square square = new Square(4.0, 4.0);

        circle.setColor("Đỏ");
        rectangle.setColor("Xanh dương");
        square.setColor("Xanh lá");

        System.out.println("Màu cu hình tròn: " + circle.getColor());
        System.out.println("Màu của hình chữ nhật: " + rectangle.getColor());
        System.out.println("Màu cảu hình vuông: " + square.getColor());
    }
}
