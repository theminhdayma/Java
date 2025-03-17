package Bai1;

import java.util.Scanner;

public class BookManager {
    private static Book[] books;
    private static int count = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Tính lợi nhuận sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Tìm sách theo tên");
            System.out.println("5. Thống kê sách theo năm");
            System.out.println("6. Thống kê sách theo tác giả");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inputBooks();
                    break;
                case 2:
                    calculateInterest();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    searchBookByName();
                    break;
                case 5:
                    countBooksByYear();
                    break;
                case 6:
                    countBooksByAuthor();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chọn không hợp lệ! Hãy nhập lại.");
            }
        } while (choice != 7);
    }

    private static void inputBooks() {
        System.out.print("Nhập số lượng sách: ");
        int n = sc.nextInt();
        sc.nextLine();
        books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sách " + (i + 1) + ":");
            books[i] = Book.inputBook(sc, books, count);
            count++;
        }
    }

    private static void calculateInterest() {
        if (books == null || count == 0) {
            System.out.println("Chưa có sách nào!");
            return;
        }
        for (int i = 0; i < count; i++) {
            books[i].calculateInterest();
        }
        System.out.println("Đã tính lợi nhuận cho tất cả sách.");
    }

    private static void displayBooks() {
        if (books == null || count == 0) {
            System.out.println("Chưa có sách nào!");
            return;
        }
        for (int i = 0; i < count; i++) {
            books[i].displayInfo();
        }
    }

    private static void searchBookByName() {
        if (books == null || count == 0) {
            System.out.println("Chưa có sách nào!");
            return;
        }
        System.out.print("Nhập tên sách cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getBookName().equalsIgnoreCase(name)) {
                books[i].displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sách.");
    }

    private static void countBooksByYear() {
        if (books == null || count == 0) {
            System.out.println("Chưa có sách nào!");
            return;
        }
        int[] years = new int[100];
        for (int i = 0; i < count; i++) {
            years[books[i].getYear() - 2000]++;
        }
        for (int i = 0; i < years.length; i++) {
            if (years[i] > 0) {
                System.out.println("Năm " + (i + 2000) + ": " + years[i] + " sách");
            }
        }
    }

    private static void countBooksByAuthor() {
        if (books == null || count == 0) {
            System.out.println("Chưa có sách nào!");
            return;
        }
        String[] authors = new String[count];
        int[] counts = new int[count];
        int size = 0;

        for (int i = 0; i < count; i++) {
            boolean found = false;
            for (int j = 0; j < size; j++) {
                if (authors[j].equals(books[i].getAuthor())) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                authors[size] = books[i].getAuthor();
                counts[size] = 1;
                size++;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Tác giả " + authors[i] + ": " + counts[i] + " sách");
        }
    }
}
