class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceTo(Point2D p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    public void displayPoint() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

public class Bai6 {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(1, 2);
        Point2D p2 = new Point2D(3, 4);

        System.out.print("Điểm p1: ");
        p1.displayPoint();
        System.out.print("Điểm p2: ");
        p2.displayPoint();

        System.out.println("Khoảng cách giữa p1 và p2: " + p1.distanceTo(p2));

        p1.setX(5);
        p1.setY(6);

        System.out.print("Tọa độ mới của p1: ");
        p1.displayPoint();
    }
}
