package Bai10;

class Student {
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String classify() {
        if (gpa >= 8.5) return "Xuất sắc";
        if (gpa >= 7.0) return "Giỏi";
        if (gpa >= 5.5) return "Khá";
        return "Trung bình/Yếu";
    }

    public void display() {
        System.out.println("--------------------------");
        System.out.println("Mã sinh viên: " + id);
        System.out.println("Tên sinh viên: " + name);
        System.out.println("Điểm GPA: " + gpa);
    }
}
