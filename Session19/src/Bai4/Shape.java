package Bai4;

interface Shape {
    default double area() {
        return 0;
    }

    static void description() {
        System.out.println("This is a shape");
    }
}
