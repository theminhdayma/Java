package Bai10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        String filename = "students.dat";

        int choice;
        do {
            System.out.println("---------------MENU-----------------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Ghi danh sách vào file");
            System.out.println("4. Đọc danh sách từ file");
            System.out.println("5. Tìm sinh viên có GPA cao nhất");
            System.out.println("6. Tìm sinh viên theo chuyên ngành");
            System.out.println("7. Tính GPA trung bình");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập chuyên ngành: ");
                    String major = scanner.nextLine();
                    System.out.print("Nhập GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();
                    manager.addStudent(new Student(id, name, major, gpa));
                    System.out.println("Đã thêm sinh viên.");
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    manager.saveToFile(filename);
                    break;

                case 4:
                    manager.loadFromFile(filename);
                    break;

                case 5:
                    Student topStudent = manager.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("SINH VIÊN XUẤT SẮC NHẤT:");
                        System.out.println(topStudent);
                    } else {
                        System.out.println("Không có sinh viên nào.");
                    }
                    break;

                case 6:
                    System.out.print("Nhập chuyên ngành cần tìm: ");
                    String searchMajor = scanner.nextLine();
                    manager.searchByMajor(searchMajor).forEach(System.out::println);
                    break;

                case 7:
                    System.out.printf("GPA trung bình: %.2f", manager.calculateAverageGpa());
                    break;

                case 8:
                    System.out.println("Thoát...!!!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.Vui lòng chọn từ 1 đến 8");
            }
        } while (choice != 8);
    }
}

