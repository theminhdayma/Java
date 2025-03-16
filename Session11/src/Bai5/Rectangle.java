package Bai5;

public class Rectangle implements Colorable {
    private String color;
    private double width;
    private double height;

    public Rectangle(double length, double width) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}
