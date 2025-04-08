
package presentation;

import business.model.Student;
import business.service.Student.StudentService;
import business.service.Student.StudentServiceImp;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    private final StudentService studentService;

    public StudentUI() {
        studentService = new StudentServiceImp();
    }

    public static void displayStudentMenu(Scanner scanner) {
        StudentUI studentUI = new StudentUI();
        do {
            System.out.println("***************STUDENT MANAGEMENT****************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thống kê sinh viên theo trạng thái");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentUI.displayListStudents();
                    break;
                case 2:
                    studentUI.createStudents(scanner);
                    break;
                case 3:
                    studentUI.updateStudent(scanner);
                    break;
                case 4:
                    studentUI.deleteStudent(scanner);
                    break;
                case 5:
                    studentUI.countStudent(scanner);
                    break;
                case 6:
                    System.out.println("Quay lại menu chính");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    public void displayListStudents() {
        List<Student> listStudents = studentService.findAll();
        if (listStudents != null && !listStudents.isEmpty()) {
            listStudents.forEach(System.out::println);
        } else {
            System.out.println("Danh sách sinh viên trống.");
        }
    }


    public void createStudents(Scanner scanner) {
        System.out.println("Nhập vào số sinh viên cần thêm mới:");
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            Student student = new Student();
            student.inputData(scanner);
            boolean result = studentService.save(student);
            if (result) {
                System.out.println("Thêm mới thành công");
            } else {
                System.err.println("Có lỗi trong quá trình thêm mới");
            }
        }
    }

    public void updateStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        int studentId = Integer.parseInt(scanner.nextLine());
        Student student = studentService.findById(studentId);

        if (student != null) {
            int choice;
            do {
                System.out.println("\n--- CẬP NHẬT THÔNG TIN SINH VIÊN ---");
                System.out.println("1. Cập nhật tên");
                System.out.println("2. Cập nhật tuổi");
                System.out.println("3. Cập nhật trạng thái");
                System.out.println("4. Hoàn tất cập nhật");
                System.out.print("Chọn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        student.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập tuổi mới: ");
                        student.setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.print("Nhập trạng thái mới: ");
                        student.setStatus(scanner.nextBoolean());
                        break;
                    case 4:
                        System.out.println("Đã hoàn tất cập nhật.");
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } while (choice != 4);

            boolean result = studentService.update(student);
            if (result) {
                System.out.println("Cập nhật sinh viên thành công!");
            } else {
                System.err.println("Có lỗi trong quá trình cập nhật.");
            }

        } else {
            System.err.println("Không tìm thấy sinh viên với ID đã nhập.");
        }
    }


    public void deleteStudent(Scanner scanner) {
        System.out.println("Nhập mã sinh viên cần xóa:");
        int studentId = Integer.parseInt(scanner.nextLine());
        if (studentService.findById(studentId) != null) {
            Student student = new Student();
            student.setId(studentId);
            boolean result = studentService.delete(student);
            System.out.println("Xóa sinh viên thành công !");
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    public void countStudent(Scanner scanner) {
        System.out.println("Nhập vào trạng thái cần thống kế:");
        boolean status = Boolean.parseBoolean(scanner.nextLine());
        System.out.printf("Trạng thái %b có %d sinh viên\n", status, studentService.getCountStudentByStatus(status));
    }
}
