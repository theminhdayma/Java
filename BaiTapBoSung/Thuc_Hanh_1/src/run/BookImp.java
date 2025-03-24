package run;

import entity.Book;
import java.util.*;

public class BookImp {
    private static List<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n************* MENU *************");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> inputBooks();
                case 2 -> calculateProfit();
                case 3 -> displayBooks();
                case 4 -> sortByPrice();
                case 5 -> sortByProfit();
                case 6 -> searchBookByName();
                case 7 -> countBooksByYear();
                case 8 -> countBooksByAuthor();
                case 9 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice != 9);
    }

    private static boolean checkListBook() {
        if (bookList.isEmpty()) {
            System.err.println("Danh sách rỗng");
            return false;
        }
        return true;
    }

    private static void inputBooks() {
        System.out.print("Nhập số lượng sách: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputData(scanner);
            bookList.add(book);
        }
    }

    private static void calculateProfit() {
        for (Book book : bookList) {
            System.out.println("Lợi nhuận sách '" + book.getBookName() + "': " + book.getInterest());
        }
    }

    private static void displayBooks() {
        if (checkListBook()) {
            System.out.println("DANH SÁCH SÁCH: ");
            for (Book book : bookList) {
                book.displayData();
            }
        }
    }

    private static void sortByPrice() {
        if (checkListBook()) {
            bookList.sort(Comparator.comparing(Book::getExportPrice));
            System.out.println("Đã sắp xếp sách theo giá bán tăng dần.");
        }
    }

    private static void sortByProfit() {
        if (checkListBook()) {
            bookList.sort((b1, b2) -> Float.compare(b2.getInterest(), b1.getInterest()));
            System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần.");
        }
    }

    private static void searchBookByName() {
        if (checkListBook()) {
            System.out.print("Nhập tên sách cần tìm: ");
            String name = scanner.nextLine();
            for (Book book : bookList) {
                if (book.getBookName().equalsIgnoreCase(name)) {
                    book.displayData();
                    return;
                }
            }
            System.out.println("Không tìm thấy sách.");
        }
    }

    private static void countBooksByYear() {
        if (checkListBook()) {
            Map<Integer, Integer> countByYear = new HashMap<>();
            for (Book book : bookList) {
                countByYear.put(book.getYear(), countByYear.getOrDefault(book.getYear(), 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : countByYear.entrySet()) {
                System.out.println("Năm " + entry.getKey() + ": " + entry.getValue() + " sách.");
            }
        }
    }

    private static void countBooksByAuthor() {
        if (checkListBook()) {
            Map<String, Integer> countByAuthor = new HashMap<>();
            for (Book book : bookList) {
                countByAuthor.put(book.getAuthor(), countByAuthor.getOrDefault(book.getAuthor(), 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : countByAuthor.entrySet()) {
                System.out.println("Tác giả " + entry.getKey() + ": " + entry.getValue() + " sách.");
            }
        }
    }
}