class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
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

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MoveablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    @Override
    public String toString() {
        return super.toString() + " với tốc độ (" + xSpeed + ", " + ySpeed + ")";
    }
}

public class Bai6 {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println("Điểm ban đầu: " + point);

        // Tạo đối tượng MoveablePoint
        MoveablePoint moveablePoint = new MoveablePoint(1, 2, 3, 4);
        System.out.println("Điểm di chuyển ban đầu: " + moveablePoint);

        moveablePoint.move();
        System.out.println("Điểm sau khi di chuyển: " + moveablePoint);

        moveablePoint.setXSpeed(5);
        moveablePoint.setYSpeed(-1);
        moveablePoint.move();
        System.out.println("Điểm sau khi thay đổi tốc độ và di chuyển tiếp: " + moveablePoint);
    }
}
