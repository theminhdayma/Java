package KS23B_Java_OOP_Practice;

import java.util.Scanner;

public class BookManagement {
    private Book[] bookList = new Book[100];
    private int bookCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        int choice;
        do {
            System.out.println("****************************MENU*************************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá (tìm theo khoảng giá bán)");
            System.out.println("9. Thống kê sách theo mỗi tác giả");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    calculateProfit();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    sortBooksByProfit();
                    break;
                case 7:
                    searchByAuthor();
                    break;
                case 8:
                    searchByPriceRange();
                    break;
                case 9:
                    statisticsByAuthor();
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Nhập lại");
            }
        } while (choice != 10);
    }

    private void listBooks() {
        if (bookCount == 0) {
            System.out.println("Danh sách sách trống");
        } else {
            for (int i = 0; i < bookCount; i++) {
                bookList[i].displayData();
            }
        }
    }

    private void addBook() {
        if (bookCount >= bookList.length) {
            System.out.println("Không thể thêm sách, danh sách đã đầy.");
            return;
        }
        Book book = new Book();
        book.inputData(scanner);
        bookList[bookCount++] = book;
        System.out.println("Thêm sách thành công!");
    }

    private void calculateProfit() {
        int sum = 0;
        for (int i = 0; i < bookCount; i++) {
            sum += bookList[i].getInterest();
        }
        System.out.println("Lợi nhuận của các sách: " + sum);
    }

    private int findBookById (String bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId().equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    private void updateBook() {
        System.out.print("Nhập mã sách cần cập nhật: ");
        String id = scanner.nextLine();
        int index = findBookById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sách!");
        } else {
            boolean isExit = true;
            do {
                System.out.println("Chọn thuộc tính cần cập nhật:");
                System.out.println("1. Tên sách");
                System.out.println("2. Giá nhập");
                System.out.println("3. Giá bán");
                System.out.println("4. Tác giả");
                System.out.println("5. Tiêu đề");
                System.out.println("6. Năm xuất bản");
                System.out.println("7. Thoát cập nhật");
                System.out.print("Nhập lựa chọn của bạn: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên sách mới: ");
                        bookList[index].setBookName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập giá nhập mới: ");
                        bookList[index].setImportPrice(scanner.nextDouble());
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("Nhập giá bán mới: ");
                        bookList[index].setExportPrice(scanner.nextDouble());
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.print("Nhập tác giả mới: ");
                        bookList[index].setAuthor(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhập tiêu đề mới: ");
                        bookList[index].setTitle(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("Nhập năm xuất bản mới: ");
                        bookList[index].setYear(scanner.nextInt());
                        scanner.nextLine();
                        break;
                    case 7:
                        System.out.println("Cập nhật thành công!");
                        isExit = false;
                        break;
                    default:
                        System.out.println("Vui lòng chọn từ 1 đến 5");
                }
            } while (isExit);
        }
    }

    private void deleteBook() {
        System.out.print("Nhập mã sách cần xóa: ");
        String id = scanner.nextLine();
        int index = findBookById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sách!");
        } else {
            for (int i = index; i < bookCount; i++) {
                bookList[i] = bookList[i + 1];
            }
            bookCount--;
        }
    }

    private void sortBooksByProfit() {
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = 0; j < bookCount - i - 1; j++) {
                if (bookList[j].getInterest() > bookList[j + 1].getInterest()) {
                    Book temp = bookList[j];
                    bookList[j] = bookList[j + 1];
                    bookList[j + 1] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }


    private void searchByAuthor() {
        System.out.print("Nhập tên tác giả: ");
        String author = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getAuthor().toLowerCase().contains(author.toLowerCase())) {

                bookList[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có tác giả nào phù hợp.");
        }
    }


    private void searchByPriceRange() {
        System.out.print("Nhập giá bán thấp nhất: ");
        double min = scanner.nextDouble();
        System.out.print("Nhập giá bán cao nhất: ");
        double max = scanner.nextDouble();
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getExportPrice() >= min && bookList[i].getExportPrice() <= max) {
                bookList[i].displayData();
            }
        }
    }

    private void statisticsByAuthor() {
        String[] authors = new String[bookCount];
        int[] counts = new int[bookCount];
        int authorCount = 0;

        for (int i = 0; i < bookCount; i++) {
            String author = bookList[i].getAuthor();
            boolean found = false;
            for (int j = 0; j < authorCount; j++) {
                if (authors[j].equals(author)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                authors[authorCount] = author;
                counts[authorCount] = 1;
                authorCount++;
            }
        }

        for (int i = 0; i < authorCount; i++) {
            System.out.println("Tác giả: " + authors[i] + " - Số lượng sách: " + counts[i]);
        }
    }

    public static void main(String[] args) {
        BookManagement bm = new BookManagement();
        bm.displayMenu();
    }
}
