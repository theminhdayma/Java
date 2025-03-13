class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            System.out.println("Bán kính không hợp lệ");
            this.radius = 1;
        } else {
            this.radius = radius;
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        setHeight(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Chiều cao không hợp lệ");
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    public double getVolume() {
        return getArea() * height;
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println("Diện tích hình tròn: " + circle.getArea());

        Cylinder cylinder = new Cylinder(2, 5);
        System.out.println("Thể tích hình trụ: " + cylinder.getVolume());

        circle.setRadius(-1);
        System.out.println("Diện tích hình tròn sau khi thay đổi bán kính: " + circle.getArea());

        cylinder.setHeight(10);
        System.out.println("Thể tích hình trụ sau khi thay đổi chiều cao: " + cylinder.getVolume());
    }
}
