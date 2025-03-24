package entity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Book {
    private static Set<String> bookIds = new HashSet<>();
    private static Set<String> bookNames = new HashSet<>();

    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public static Set<String> getBookIds() {
        return bookIds;
    }

    public static void setBookIds(Set<String> bookIds) {
        Book.bookIds = bookIds;
    }

    public static Set<String> getBookNames() {
        return bookNames;
    }

    public static void setBookNames(Set<String> bookNames) {
        Book.bookNames = bookNames;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void calculateInterest() {
        this.interest = exportPrice - importPrice;
    }

    public void inputData(Scanner scanner) {
        do {
            System.out.print("Nhập mã sách: ");
            bookId = scanner.nextLine();
            if (!bookIds.contains(bookId)) {
                bookIds.add(bookId);
                break;
            }
            System.err.println("Mã sách đã tồn tại! Vui lòng nhập lại.");
        } while (true);

        do {
            System.out.print("Nhập tên sách (Bxxx): ");
            bookName = scanner.nextLine();
            if (bookName.matches("^B.{3}$") && !bookNames.contains(bookName)) {
                bookNames.add(bookName);
                break;
            }
            System.err.println("Tên sách phải có 4 ký tự, bắt đầu bằng 'B' và không trùng!");
        } while (true);

        do {
            System.out.print("Nhập giá nhập: ");
            importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                break;
            }
            System.err.println("Giá nhập phải lớn hơn 0!");
        } while (true);

        do {
            System.out.print("Nhập giá xuất: ");
            exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice >= importPrice * 1.3) {
                break;
            }
            System.err.println("Giá xuất phải cao hơn ít nhất 30% giá nhập!");
        } while (true);

        calculateInterest();

        do {
            System.out.print("Nhập tên tác giả: ");
            author = scanner.nextLine();
            if (author.length() >= 6 && author.length() <= 50) {
                break;
            }
            System.err.println("Tên tác giả phải từ 6-50 ký tự!");
        } while (true);

        do {
            System.out.print("Nhập năm xuất bản: ");
            year = Integer.parseInt(scanner.nextLine());
            if (year > 2000) {
                break;
            }
            System.err.println("Năm xuất bản phải sau năm 2000!");
        } while (true);
    }

    public void displayData() {
        System.out.println("-----------------------------");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("Lợi nhuận: " + interest);
    }
}
