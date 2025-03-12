package KS23B_Java_OOP_Practice;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {}

    public Book(String bookId, String bookName, double importPrice, double exportPrice,
                String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        calInterest();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        if (bookId.matches("B\\d{4}")) {
            this.bookId = bookId;
        } else {
            System.out.println("Mã sách phải có 5 ký tự và bắt đầu bằng 'B'");
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName.length() >= 6 && bookName.length() <= 100) {
            this.bookName = bookName;
        } else {
            System.out.println("Tên sách phải từ 6-100 ký tự");
        }
    }

    public void setImportPrice(double importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            System.out.println("Giá nhập phải lớn hơn 0");
        }
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        if (exportPrice >= importPrice * 1.1) {
            this.exportPrice = exportPrice;
        } else {
            System.out.println("Giá bán phải lớn hơn ít nhất 10% giá nhập");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Tiêu đề sách không được để trống");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Tác giả không được để trống");
        }
    }

    public double getInterest() {
        return interest;
    }

    public void calInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1970) {
            this.year = year;
        } else {
            System.out.println("Năm xuất bản phải sau năm 1970");
        }
    }

    public boolean inputData(Scanner scanner) {
        System.out.print("Nhập mã sách (Bxxxx): ");
        String bookId = scanner.nextLine();
        setBookId(bookId);
        if (!bookId.equals(this.bookId)) return false;

        System.out.print("Nhập tên sách: ");
        String bookName = scanner.nextLine();
        setBookName(bookName);
        if (!bookName.equals(this.bookName)) return false;

        System.out.print("Nhập giá nhập: ");
        double importPrice = scanner.nextDouble();
        setImportPrice(importPrice);
        if (this.importPrice != importPrice) return false;

        System.out.print("Nhập giá bán: ");
        double exportPrice = scanner.nextDouble();
        setExportPrice(exportPrice);
        if (this.exportPrice != exportPrice) return false;
        scanner.nextLine(); // Consume newline

        System.out.print("Nhập tiêu đề: ");
        String title = scanner.nextLine();
        setTitle(title);
        if (!title.equals(this.title)) return false;

        System.out.print("Nhập tác giả: ");
        String author = scanner.nextLine();
        setAuthor(author);
        if (!author.equals(this.author)) return false;

        System.out.print("Nhập năm xuất bản: ");
        int year = scanner.nextInt();
        setYear(year);
        if (this.year != year) return false;

        calInterest();
        return true; // Nếu qua tất cả kiểm tra, trả về true
    }

    // Phương thức hiển thị thông tin sách
    public void displayData() {
        System.out.println("-----------------------------");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá bán: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Năm xuất bản: " + year);
    }

}

