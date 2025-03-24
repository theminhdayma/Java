package bussiness;

import entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class StudentBussiness {
    static ArrayList<Student> students = new ArrayList<Student>();

    public static void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);
        students.add(student);
        System.out.println("Thêm sinh viên thành công!");
    }

    public static void displayAllStudents(){
        System.out.println("Danh sách sinh viên:");
        for (Student student : students) {
            student.displayData();
        }
    }
    public static void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên cần sửa: ");
        String id = scanner.nextLine();
        Student student = null;

        for (Student s : students) {
            if (s.getStudentId() == id) {
                student = s;
                break;
            }
        }

        if (student != null) {
            System.out.println("Chọn thông tin cần sửa:");
            System.out.println("1. Tên sinh viên");
            System.out.println("2. Ngày sinh");
            System.out.println("3. Số điện thoại");
            System.out.println("4. Email");
            System.out.println("5. Ngành học");
            System.out.println("6. Tên lớp");
            System.out.println("7. Điểm GPA");
            System.out.println("8. Giới tính");
            System.out.print("Lựa chọn của bạn (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    student.setStudentName(newName);
                    break;
                case 2:
                    System.out.print("Nhập ngày sinh mới: ");
                    String newBirthday = scanner.nextLine();
                    student.setBirthday(newBirthday);
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại mới: ");
                    String newPhone = scanner.nextLine();
                    student.setPhoneNumber(newPhone);
                    break;
                case 4:
                    System.out.print("Nhập email mới: ");
                    String newEmail = scanner.nextLine();
                    student.setEmail(newEmail);
                    break;
                case 5:
                    System.out.print("Nhập ngành học mới: ");
                    String newMajor = scanner.nextLine();
                    student.setMajor(newMajor);
                    break;
                case 6:
                    System.out.print("Nhập tên lớp mới: ");
                    String newClass = scanner.nextLine();
                    student.setClassName(newClass);
                    break;
                case 7:
                    System.out.print("Nhập điểm GPA mới: ");
                    float newGpa = scanner.nextFloat();
                    student.setGpa(newGpa);
                    break;
                case 8:
                    System.out.print("Nhập giới tính (true cho Nam, false cho Nữ): ");
                    boolean newSex = scanner.nextBoolean();
                    student.setSex(newSex);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
            System.out.println("Sửa thông tin sinh viên thành công!");

            System.out.println("Thông tin sau khi cập nhật:");
            System.out.println("Tên sinh viên: " + student.getStudentName());
            System.out.println("Ngày sinh: " + student.getBirthday());
            System.out.println("Số điện thoại: " + student.getPhoneNumber());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Ngành học: " + student.getMajor());
            System.out.println("Tên lớp: " + student.getClassName());
            System.out.println("Điểm GPA: " + student.getGpa());
            System.out.println("Giới tính: " + (student.getSex() ? "Nam" : "Nữ"));

        } else {
            System.out.println("Sinh viên không tồn tại!");
        }
    }

    public static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên cần xóa: ");
        String id = scanner.nextLine();
        Student student = null;

        for (Student s : students) {
            if (s.getStudentId() == id) {
                student = s;
                break;
            }
        }

        if (student != null) {
            students.remove(student);
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Sinh viên không tồn tại!");
        }
    }

    public static void searchStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENU TÌM KIẾM SINH VIÊN ===");
        System.out.println("1. Tìm kiếm theo tên sinh viên");
        System.out.println("2. Tìm kiếm theo lớp học");
        System.out.println("3. Tìm kiếm theo khoảng điểm tích lũy");
        System.out.print("Chọn tiêu chí tìm kiếm (1-3): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhập tên sinh viên cần tìm: ");
                String searchName = scanner.nextLine().toLowerCase();
                boolean foundByName = false;

                for (Student student : students) {
                    if (student.getStudentName().toLowerCase().contains(searchName)) {
                        displayStudentInfo(student);
                        foundByName = true;
                    }
                }
                if (!foundByName) {
                    System.out.println("Không tìm thấy sinh viên nào với tên: " + searchName);
                }
                break;

            case 2:
                System.out.print("Nhập tên lớp cần tìm: ");
                String searchClass = scanner.nextLine().toLowerCase();
                boolean foundByClass = false;

                for (Student student : students) {
                    if (student.getClassName().toLowerCase().equals(searchClass)) {
                        displayStudentInfo(student);
                        foundByClass = true;
                    }
                }
                if (!foundByClass) {
                    System.out.println("Không tìm thấy sinh viên nào trong lớp: " + searchClass);
                }
                break;

            case 3:
                System.out.print("Nhập điểm thấp nhất: ");
                float minGpa = scanner.nextFloat();
                System.out.print("Nhập điểm cao nhất: ");
                float maxGpa = scanner.nextFloat();
                boolean foundByGpa = false;

                if (minGpa > maxGpa) {
                    System.out.println("Điểm thấp nhất phải nhỏ hơn hoặc bằng điểm cao nhất!");
                    break;
                }

                for (Student student : students) {
                    float gpa = student.getGpa();
                    if (gpa >= minGpa && gpa <= maxGpa) {
                        displayStudentInfo(student);
                        foundByGpa = true;
                    }
                }
                if (!foundByGpa) {
                    System.out.println("Không tìm thấy sinh viên nào trong khoảng điểm " +
                            minGpa + " - " + maxGpa);
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                break;
        }
    }
    private static void displayStudentInfo(Student student) {
        System.out.println("------------------------");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Tên sinh viên: " + student.getStudentName());
        System.out.println("Ngày sinh: " + student.getBirthday());
        System.out.println("Số điện thoại: " + student.getPhoneNumber());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Ngành học: " + student.getMajor());
        System.out.println("Tên lớp: " + student.getClassName());
        System.out.println("Điểm GPA: " + student.getGpa());
        System.out.println("Giới tính: " + (student.getSex() ? "Nam" : "Nữ"));
    }

    public static void sortStudents() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENU SẮP XẾP SINH VIÊN ===");
        System.out.println("1. Sắp xếp theo tên tăng dần");
        System.out.println("2. Sắp xếp theo tên giảm dần");
        System.out.println("3. Sắp xếp theo GPA tăng dần");
        System.out.println("4. Sắp xếp theo GPA giảm dần");
        System.out.print("Chọn tiêu chí sắp xếp (1-4): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Collections.sort(students, (s1, s2) ->
                        s1.getStudentName().compareToIgnoreCase(s2.getStudentName()));
                System.out.println("Đã sắp xếp theo tên tăng dần!");
                break;

            case 2:
                Collections.sort(students, (s1, s2) ->
                        s2.getStudentName().compareToIgnoreCase(s1.getStudentName()));
                System.out.println("Đã sắp xếp theo tên giảm dần!");
                break;

            case 3:
                Collections.sort(students, (s1, s2) ->
                        Float.compare(s1.getGpa(), s2.getGpa()));
                System.out.println("Đã sắp xếp theo GPA tăng dần!");
                break;

            case 4:
                Collections.sort(students, (s1, s2) ->
                        Float.compare(s2.getGpa(), s1.getGpa()));
                System.out.println("Đã sắp xếp theo GPA giảm dần!");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        System.out.println("\nDanh sách sinh viên sau khi sắp xếp:");
        for (Student student : students) {
            displayStudentInfo(student);
        }
    }
}
