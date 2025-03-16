package Bai4;

class Shape {
    double area() {
        return 0;
    }

    double area(double radius) {
        return Math.PI * radius * radius;
    }

    double area(double width, double height) {
        return width * height;
    }
}

