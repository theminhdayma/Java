package Bai10;

import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Dữ liệu đã được lưu vào file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Đã đọc dữ liệu từ file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student findTopStudent() {
        return students.stream().max(Comparator.comparingDouble(Student::getGpa)).orElse(null);
    }

    public List<Student> searchByMajor(String major) {
        System.out.println("🔍 KẾT QUẢ TÌM KIẾM:");
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().toLowerCase().contains(major.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public double calculateAverageGpa() {
        if (students.isEmpty()) return 0.0;
        return students.stream().mapToDouble(Student::getGpa).average().orElse(0.0);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("DANH SÁCH SINH VIÊN:");
            students.forEach(System.out::println);
        }
    }
}

