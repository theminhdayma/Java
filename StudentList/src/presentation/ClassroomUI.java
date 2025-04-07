package presentation;

import business.model.ClassRoom;
import business.service.classroom.ClassroomServiceImp;
import java.util.List;
import java.util.Scanner;

public class ClassroomUI {
    private final ClassroomServiceImp classroomService;

    public ClassroomUI() {
        classroomService = new ClassroomServiceImp();
    }

    public static void displayClassroomMenu(Scanner scanner) {
        ClassroomUI classroomUI = new ClassroomUI();
        do {
            System.out.println("***************CLASSROOM MANAGEMENT****************");
            System.out.println("1. Danh sách lớp học");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    classroomUI.displayListClassrooms();
                    break;
                case 2:
                    classroomUI.createClassroom(scanner);
                    break;
                case 3:
                    classroomUI.updateClassroom(scanner);
                    break;
                case 4:
                    classroomUI.deleteClassroom(scanner);
                    break;
                case 5:
                    System.out.println("Quay lại menu chính");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (true);
    }

    public void displayListClassrooms() {
        List<ClassRoom> listClassrooms = classroomService.findAll();
        if (listClassrooms.isEmpty()) {
            System.out.println("Chưa có lớp học nào.");
        } else {
            listClassrooms.forEach(System.out::println);
        }
    }

    public void createClassroom(Scanner scanner) {
        ClassRoom classroom = new ClassRoom();
        classroom.inputData(scanner);
        boolean result = classroomService.save(classroom);
        if (result) {
            System.out.println("Thêm mới lớp học thành công");
        } else {
            System.err.println("Có lỗi trong quá trình thêm mới");
        }
    }

    public void updateClassroom(Scanner scanner) {
        System.out.println("Nhập vào mã lớp học cần cập nhật:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        ClassRoom existingClassroom = classroomService.findById(classroomId);
        if (existingClassroom != null) {
            ClassRoom classroom = new ClassRoom();
            classroom.setId(classroomId);
            classroom.inputData(scanner);
            boolean result = classroomService.update(classroom);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Có lỗi trong quá trình cập nhật");
            }
        } else {
            System.err.println("Không tồn tại mã lớp học");
        }
    }

    public void deleteClassroom(Scanner scanner) {
        System.out.println("Nhập mã lớp học cần xóa:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        if (classroomService.findById(classroomId) != null) {
            ClassRoom classroom = new ClassRoom();
            classroom.setId(classroomId);
            boolean result = classroomService.delete(classroom);
            if (result) {
                System.out.println("Xóa lớp học thành công");
            } else {
                System.err.println("Có lỗi trong quá trình xóa");
            }
        } else {
            System.err.println("Mã lớp học không tồn tại");
        }
    }
}