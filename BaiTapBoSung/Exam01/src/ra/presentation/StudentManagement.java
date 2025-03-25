package ra.presentation;

import java.util.*;
import ra.entity.Student;

public class StudentManagement {
    private static final Map<String, Student> StudentMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Điểm trung bình cả tất cả sinh viên");
            System.out.println("5. In ra sinh viên có điểm trung bình lớn nhất");
            System.out.println("6. In ra sinh viên có độ tuổi nhỏ nhất");
            System.out.print("Chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    avgAllStudents();
                    break;
                case 5:
                    avgMaxStudent();
                    break;
                case 6:
                    ageMinStudent();
                    break;
                case 7:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Không hợp lệ, vui lòng chọn từ 1 đến 7 !");
            }
        }while (choice != 7);
    }

    private static void showAllStudents() {
        if (StudentMap.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }

        System.out.println("\nDanh sách sinh viên");
        for (Map.Entry<String, Student> entry : StudentMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void addStudent () {
        Student student = new Student();
        student.inputData();

        if (StudentMap.containsKey(student.getId())) {
            System.out.println("ID sinh viên đã tồn tại! Vui lòng nhập lại.");
            return;
        }

        StudentMap.put(student.getId(), student);
        System.out.println("Sinh viên đã được thêm thành công!");
    }

    private static void deleteStudent () {
        System.out.print("Nhập ID sinh viên cần xóa: ");
        String id = scanner.nextLine();

        if (StudentMap.remove(id) != null) {
            System.out.println("Sinh viên đã được xóa thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }

    private static void avgAllStudents () {
        float avgAllStudents = 0;
        for (Student student : StudentMap.values()) {
            avgAllStudents += student.getAvg();
        }

        System.out.println("Điểm trung bình của tất cả sinh viên: " + avgAllStudents);
    }

    private static void avgMaxStudent() {
        List<Student> students = new ArrayList<>(StudentMap.values());

        students.sort(Comparator.comparing(Student::getAvg).reversed());
        System.out.println("Sinh viên có điểm trung bình cao nhất: " + students.get(0).toString());
    }

    private static void ageMinStudent() {
        List<Student> students = new ArrayList<>(StudentMap.values());
        students.sort(Comparator.comparing(Student::getAge));
        System.out.println("Sinh viên có độ tuổi nhỏ nhất: " + students.get(0).toString());
    }
}

