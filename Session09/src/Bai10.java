import java.util.Scanner;

enum Gender {
    MALE, FEMALE, OTHER;
}

class Student {
    int id;
    String name;
    int age;
    Gender gender;
    String address;
    String phoneNumber;

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[1000];
        int count = 0;
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên theo mã");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (count == 0) {
                        System.out.println("Danh sách sinh viên trống.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("ID: " + students[i].id);
                            System.out.println("Tên: " + students[i].name);
                            System.out.println("Tuổi: " + students[i].age);
                            System.out.println("Giới tính: " + students[i].gender);
                            System.out.println("Địa chỉ: " + students[i].address);
                            System.out.println("SĐT: " + students[i].phoneNumber);
                            System.out.println("----------------------------");
                        }
                    }
                    break;
                case 2:
                    if (count >= students.length) {
                        System.out.println("Danh sách đã đầy.");
                        break;
                    }

                    System.out.print("Nhập mã học sinh: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên học sinh: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập giới tính (MALE, FEMALE, OTHER): ");
                    Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Nhập địa chỉ: ");
                    String address = sc.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = sc.nextLine();

                    students[count] = new Student(id, name, age, gender, address, phoneNumber);
                    count++;
                    System.out.println("Thêm sinh viên thành công!");
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần sửa: ");
                    int editId = Integer.parseInt(sc.nextLine());
                    boolean foundEdit = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == editId) {
                            foundEdit = true;
                            System.out.println("NHẬP THÔNG TIN MỚI");

                            System.out.print("Nhập tên học sinh: ");
                            students[i].name = sc.nextLine();

                            System.out.print("Nhập tuổi: ");
                            students[i].age = Integer.parseInt(sc.nextLine());

                            System.out.print("Nhập giới tính (MALE, FEMALE, OTHER): ");
                            students[i].gender = Gender.valueOf(sc.nextLine().toUpperCase());

                            System.out.print("Nhập địa chỉ: ");
                            students[i].address = sc.nextLine();

                            System.out.print("Nhập số điện thoại: ");
                            students[i].phoneNumber = sc.nextLine();

                            System.out.println("Cập nhật thành công!");
                            break;
                        }
                    }
                    if (!foundEdit) {
                        System.out.println("Không tìm thấy sinh viên");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    boolean foundDelete = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == deleteId) {
                            foundDelete = true;
                            for (int j = i; j < count - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            count--;
                            System.out.println("Xóa thành công!");
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("Không tìm thấy sinh viên");
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Không hợp lệ!");
            }
        } while (choice != 5);
    }
}
