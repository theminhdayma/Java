package bussiness;

import entity.Book;
import presentation.BookApplication;
import validate.BookValidate;
import validate.StringRule;

import java.util.Scanner;

public class BookBusiness {
    public static void displayBook() {
        if (BookApplication.countIndex == 0) {
            System.out.println("Chưa có cuốn sách nào");
            return;
        }
        for (int i = 0; i < BookApplication.countIndex; i++) {
            BookApplication.listBook[i].displayData();
        }
    }

    public static void addBook(Scanner scanner) {
        if (BookApplication.countIndex == BookApplication.listBook.length) {
            System.err.println("Danh sách đầy, không thể thêm");
            return;
        }

        int numberOfCategories = BookValidate.validateInputInt(scanner, "Nhập số loại sách muô thêm");
        for (int i = 0; i < numberOfCategories; i++) {
            System.out.printf("Nhập thông tin sách %d: \n", i+1);
            BookApplication.listBook[BookApplication.countIndex] = new Book();
            BookApplication.listBook[BookApplication.countIndex].inputData(scanner);
            BookApplication.countIndex++;
        }
    }

    public static int findIndexById(String bookId) {
        for (int i = 0; i < BookApplication.countIndex; i++) {
            if (BookApplication.listBook[i].getBookId().equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateBook(Scanner scanner) {
        String bookId = BookValidate.validateInputString(scanner, "Nhập vào mã sách cần cập nhật", new StringRule(0, 6));
        int indexUpdate = findIndexById(bookId);
        if (indexUpdate == -1) {
            System.err.println("Không tồn tại mã sách");
            return;
        }
        do {
            System.out.println("1. Cập nhật tiêu đề sách");
            System.out.println("2. Cập nhật tên tác giả");
            System.out.println("3. Cập nhật nhà xuất bản");
            System.out.println("4. Cập nhật năm xuất bản");
            System.out.println("5. Cập nhật thể loại");
            System.out.println("6. Cập nhật giá sách");
            System.out.println("7. Cập nhật số lượng");
            System.out.println("8. Thoát");
            int choice = BookValidate.validateInputInt(scanner, "Lựa chọn");
            switch (choice) {
                case 1:
                    String bookTitle = BookValidate.validateInputString(scanner, "Nhập tiêu đề sách mới", new StringRule(0, 100));
                    BookApplication.listBook[indexUpdate].setBookTitle(bookTitle);
                    break;
                case 2:
                    BookApplication.listBook[indexUpdate].setAuthor(BookValidate.validateInputString(scanner, "Nhập tên tác giả mới", new StringRule(0, 50)));
                    break;
                case 3:
                    BookApplication.listBook[indexUpdate].setPublisher(BookValidate.validateInputString(scanner, "Nhập tên nhà xuất bản mới", new StringRule(0, 100)));
                    break;
                case 4:
                    BookApplication.listBook[indexUpdate].setPublicationYear(BookValidate.validateInputInt(scanner, "Nhập nawm xuất bản mới"));
                    break;
                case 5:
                    BookApplication.listBook[indexUpdate].setCategory(BookValidate.validateInputString(scanner, "Nhập thể loại mới", new StringRule(0, 100)));
                    break;
                case 6:
                    BookApplication.listBook[indexUpdate].setPrice(BookValidate.validateInputDouble(scanner, "Nhập giá sách mới", 0));
                    break;
                case 7:
                    BookApplication.listBook[indexUpdate].setQuantity(BookValidate.validateInputInt(scanner, "Nhập số lượng sách mới"));
                    break;
                case 8:
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-8");
            }
        } while (true);
    }

    public static void deleteBook(Scanner scanner) {
        String bookId = BookValidate.validateInputString(scanner, "Nhập vào mã danh mục cân xóa", new StringRule(0, 5));
        int indexDelete = findIndexById(bookId);
        if (indexDelete == -1) {
            System.err.println("Mã sách không tồn tại");
            return;
        }
        for (int i = indexDelete; i < BookApplication.countIndex; i++) {
            BookApplication.listBook[i] = BookApplication.listBook[i + 1];
        }
        BookApplication.countIndex--;
        System.out.println("Xóa sách thành công !!!");
    }

    public static void searchBook(Scanner scanner) {
        System.out.println("===== MENU TÌM KIẾM SÁCH =====");
        System.out.println("1. Tìm theo tiêu đề sách");
        System.out.println("2. Tìm theo thể loại");
        System.out.println("3. Tìm theo khoảng giá");
        System.out.print("Chọn tiêu chí tìm kiếm: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        switch (choice) {
            case 1:
                System.out.print("Nhập tiêu đề sách: ");
                String titleKeyword = scanner.nextLine().trim().toLowerCase();
                for (int i = 0; i < BookApplication.countIndex; i++) {
                    Book book = BookApplication.listBook[i];
                    if (book.getBookTitle().toLowerCase().contains(titleKeyword)) {
                        book.displayData();
                        found = true;
                    }
                }
                break;

            case 2:
                System.out.print("Nhập thể loại sách: ");
                String categoryKeyword = scanner.nextLine().trim().toLowerCase();
                for (int i = 0; i < BookApplication.countIndex; i++) {
                    Book book = BookApplication.listBook[i];
                    if (book.getCategory().toLowerCase().contains(categoryKeyword)) {
                        book.displayData();
                        found = true;
                    }
                }
                break;

            case 3:
                System.out.print("Nhập giá thấp nhất: ");
                double minPrice = scanner.nextDouble();
                System.out.print("Nhập giá cao nhất: ");
                double maxPrice = scanner.nextDouble();
                scanner.nextLine();

                for (int i = 0; i < BookApplication.countIndex; i++) {
                    Book book = BookApplication.listBook[i];
                    if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
                        book.displayData();
                        found = true;
                    }
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (!found) {
            System.out.println("Không tìm thấy sách nào phù hợp.");
        }
    }


    public static void sortBooks(Scanner scanner) {
        if (BookApplication.countIndex == 0) {
            System.out.println("Danh sách sách trống, không thể sắp xếp.");
            return;
        }

        System.out.println("Chọn tiêu chí sắp xếp:");
        System.out.println("1. Sắp xếp theo tiêu đề (A-Z)");
        System.out.println("2. Sắp xếp theo tiêu đề (Z-A)");
        System.out.println("3. Sắp xếp theo giá (Tăng dần)");
        System.out.println("4. Sắp xếp theo giá (Giảm dần)");
        int choice = BookValidate.validateInputInt(scanner, "Mời lựa chọn:");

        for (int i = 0; i < BookApplication.countIndex - 1; i++) {
            for (int j = 0; j < BookApplication.countIndex - i - 1; j++) {
                boolean found = false;

                switch (choice) {
                    case 1:
                        if (BookApplication.listBook[j].getBookTitle()
                                .compareToIgnoreCase(BookApplication.listBook[j + 1].getBookTitle()) > 0) {
                            found = true;
                        }
                        break;
                    case 2:
                        if (BookApplication.listBook[j].getBookTitle()
                                .compareToIgnoreCase(BookApplication.listBook[j + 1].getBookTitle()) < 0) {
                            found = true;
                        }
                        break;
                    case 3:
                        if (BookApplication.listBook[j].getPrice() > BookApplication.listBook[j + 1].getPrice()) {
                            found = true;
                        }
                        break;
                    case 4:
                        if (BookApplication.listBook[j].getPrice() < BookApplication.listBook[j + 1].getPrice()) {
                            found = true;
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, yêu cầu chọn lại");
                        break;
                }

                if (found) {
                    Book temp = BookApplication.listBook[j];
                    BookApplication.listBook[j] = BookApplication.listBook[j + 1];
                    BookApplication.listBook[j + 1] = temp;
                }
            }
        }

        System.out.println("Danh sách sách sau khi sắp xếp:");
        for (int i = 0; i < BookApplication.countIndex; i++) {
            BookApplication.listBook[i].displayData();
        }
    }
}
