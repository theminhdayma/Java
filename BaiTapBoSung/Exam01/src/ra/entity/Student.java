package ra.entity;

import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;
    private float avg;

    public Student() {}

    public Student(String id, String name, int age, float avg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public void inputData () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập id: ");
        id = scanner.next();
        System.out.print("Nhập tên sinh vin: ");
        name = scanner.next();
        System.out.print("Nhâ tuổi sinh viên: ");
        age = scanner.nextInt();
        System.out.print("Nhập điểm trung bình: ");
        avg = scanner.nextFloat();
    }

    @Override
    public String toString() {
        return ("ID: " + id + "\nName: " + name + "\nAge: " + age + "\nAvg: " + avg);
    }
}
