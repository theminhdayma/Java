package Demo;

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

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        calculateInterest();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        if (bookId.matches("B\\d{4}")) {
            this.bookId = bookId;
        } else {
            System.out.println("Mã sách không hợp lệ! Phải có 5 ký tự và bắt đầu bằng 'B'.");
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName.length() >= 6 && bookName.length() <= 100) {
            this.bookName = bookName;
        } else {
            System.out.println("Tên sách phải từ 6-100 ký tự.");
        }
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
            calculateInterest(); // Cập nhật lợi nhuận mỗi khi giá nhập thay đổi
        } else {
            System.out.println("Giá nhập phải lớn hơn 0.");
        }
    }

    public double getExportPrice() {
        return exportPrice;
    }


    public void setExportPrice(double exportPrice) {
        if (exportPrice >= importPrice * 1.1) {
            this.exportPrice = exportPrice;
            calculateInterest(); // Cập nhật lợi nhuận mỗi khi giá xuất thay đổi
        } else {
            System.out.println("Giá bán phải cao hơn ít nhất 10% so với giá nhập.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Tiêu đề không được để trống.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Tác giả không được để trống.");
        }
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(int i) {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1970) {
            this.year = year;
        } else {
            System.out.println("Năm xuất bản phải sau năm 1970.");
        }
    }

    public void calculateInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public boolean isValid() {
        return bookId != null && bookId.matches("B\\d{4}") &&
                bookName != null && bookName.length() >= 6 && bookName.length() <= 100 &&
                importPrice > 0 && exportPrice >= importPrice * 1.1 &&
                title != null && !title.isEmpty() &&
                author != null && !author.isEmpty() &&
                year > 1970;
    }
    public void inputDataBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách (Bxxxx): ");
        setBookId(sc.nextLine());
        System.out.print("Nhập tên sách: ");
        setBookName(sc.nextLine());
        System.out.print("Nhập giá nhập: ");
        setImportPrice(sc.nextDouble());
        System.out.print("Nhập giá bán: ");
        setExportPrice(sc.nextDouble());
        sc.nextLine();
        System.out.print("Nhập tiêu đề: ");
        setTitle(sc.nextLine());
        System.out.print("Nhập tên tác giả: ");
        setAuthor(sc.nextLine());
        System.out.print("Nhập năm xuất bản: ");
        setYear(sc.nextInt());
        calculateInterest();
    }

    public void displayBook() {
        System.out.println("Mã sách: " + getBookId());
        System.out.println("Tên sách: " + getBookName());
        System.out.println("Giá nhập vào: " + getImportPrice());
        System.out.println("Giá bán ra: " + getExportPrice());
        System.out.println("Tiêu đề sách: " + getTitle());
        System.out.println("Tác giả: " + getAuthor());
        System.out.println("Lợi nhuận: " + getInterest());
        System.out.println("Năm xuất bản: " + getYear());
    }
    public int calInterest(int importPrice, int exportPrice) {
        return  exportPrice - importPrice;
    }


}
