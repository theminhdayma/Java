package Bai5;

class Square extends Shape {
    private double width;

    Square(double width) {
        this.width = width;
    }

    @Override
    double area() {
        return width * width;
    }
}

