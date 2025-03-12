package Demo;

import Demo.Book;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    static Book[] books = new Book[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. tính lợi nhuận các quyển sách");
            System.out.println("4. cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần ");
            System.out.println("7. Tìm kiếm sách theo tác giả ");
            System.out.println("8. Tìm kiếm sách theo khoảng giá (tìm theo khoảng giá bán)");
            System.out.println("9. Thống kê sách theo mỗi tác giả ");
            System.out.println("10. thoát!");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (count == 0) {
                        System.out.println("Danh sách trống.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            books[i].displayBook();
                        }
                    }
                    break;
                case 2:
                    if (count >= books.length) {
                        System.out.println("Danh sách đã đầy!");
                        break;
                    }
                    books[count] = new Book();
                    books[count].inputDataBook();
                    count++;
                    System.out.println("Thêm thành công!");
                    break;
                case 3:
                    if (count == 0) {
                        System.out.println("Không có sách nào để tính lợi nhuận.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            books[i].calculateInterest();
                            System.out.println("Sách: " + books[i].getBookName() + " - Lợi nhuận: " + books[i].getInterest());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID sách cần cập nhật: ");
                    String editId = scanner.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].getBookId().equals(editId)) {
                            books[i].inputDataBook();
                            System.out.println("Cập nhật thành công!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Không tìm thấy sách với ID đã nhập!");
                    }
                    break;
                case 5:
                    System.out.print("Nhập ID sách cần xóa: ");
                    String deleteId = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].getBookId().equals(deleteId)) {
                            for (int j = i; j < count; j++) {
                                books[j] = books[j + 1];
                            }
                            count--;
                            System.out.println("Xóa thành công!");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách với ID đã nhập!");
                    }
                    break;
                case 6:
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            if (books[i].getInterest() > books[j].getInterest()) {
                                Book temp = books[i];
                                books[i] = books[j];
                                books[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp thành công!");
                    break;
                case 7:
                    System.out.print("Nhập tên tác giả cần tìm: ");
                    String searchAuthor = scanner.nextLine();
                    for (int i = 0; i < count; i++) {
                        if (books[i].getAuthor().equalsIgnoreCase(searchAuthor)) {
                            books[i].displayBook();
                        }
                    }
                    break;
                case 8:
                    System.out.print("Nhập khoảng giá thấp: ");
                    int low = scanner.nextInt();
                    System.out.print("Nhập khoảng giá cao: ");
                    int high = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (books[i].getExportPrice() >= low && books[i].getExportPrice() <= high) {
                            books[i].displayBook();
                        }
                    }
                    break;
                case 9:
                    System.out.println("Thống kê sách theo tác giả:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(books[i].getAuthor() + " - " + books[i].getBookName());
                    }
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 10);
    }

}