package Bai1;

import java.util.Scanner;

class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private int year;
    private float interest;

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
        this.interest = 0;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void calculateInterest() {
        this.interest = exportPrice - importPrice;
    }

    public void displayInfo() {
        System.out.println("Mã sách: " + bookId + ", Tên: " + bookName + ", Giá nhập: " + importPrice
                + ", Giá xuất: " + exportPrice + ", Lợi nhuận: " + interest
                + ", Tác giả: " + author + ", Năm: " + year);
    }

    public static Book inputBook(Scanner sc, Book[] books, int count) {
        String bookId, bookName, author;
        float importPrice, exportPrice;
        int year;

        while (true) {
            System.out.print("Nhập mã sách (duy nhất): ");
            bookId = sc.nextLine();
            if (!isBookIdExists(books, count, bookId)) break;
            System.out.println("Mã sách đã tồn tại! Nhập lại.");
        }

        while (true) {
            System.out.print("Nhập tên sách (bắt đầu bằng 'B', 4 ký tự, duy nhất): ");
            bookName = sc.nextLine();
            if (bookName.length() == 4 && bookName.charAt(0) == 'B' && !isBookNameExists(books, count, bookName)) break;
            System.out.println("Tên sách không hợp lệ! Nhập lại.");
        }

        while (true) {
            System.out.print("Nhập giá nhập (>0): ");
            importPrice = sc.nextFloat();
            if (importPrice > 0) break;
            System.out.println("Giá nhập phải lớn hơn 0!");
        }

        while (true) {
            System.out.print("Nhập giá xuất (≥ 30% giá nhập): ");
            exportPrice = sc.nextFloat();
            if (exportPrice >= 1.3 * importPrice) break;
            System.out.println("Giá xuất phải ít nhất 30% cao hơn giá nhập!");
        }
        sc.nextLine();

        System.out.print("Nhập tác giả (6-50 ký tự): ");
        author = sc.nextLine();

        System.out.print("Nhập năm xuất bản (> 2000): ");
        year = sc.nextInt();
        sc.nextLine();

        return new Book(bookId, bookName, importPrice, exportPrice, author, year);
    }

    private static boolean isBookIdExists(Book[] books, int count, String bookId) {
        for (int i = 0; i < count; i++) {
            if (books[i].bookId.equals(bookId)) return true;
        }
        return false;
    }

    private static boolean isBookNameExists(Book[] books, int count, String bookName) {
        for (int i = 0; i < count; i++) {
            if (books[i].bookName.equalsIgnoreCase(bookName)) return true;
        }
        return false;
    }
}


