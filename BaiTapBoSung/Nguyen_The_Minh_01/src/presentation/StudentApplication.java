package presentation;

import java.util.Scanner;

import static bussiness.StudentBussiness.*;

public class StudentApplication {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        do{

            System.out.println("==================MENU================");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Chỉnh sửa sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo lựa chọn");
            System.out.println("6. Sắp xếp sinh viên theo lựa chọn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    sortStudents();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ, vui lòng chọn lại");
            }
        }while (true);
    }



}
