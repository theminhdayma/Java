package Bai9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(new Book("B001", "Lập trình Java", "Nguyễn Thanh Tùng", 2010));
        bookSet.add(new Book("B002", "Nhập môn Python", "Trần Minh Hoàng", 2015));
        bookSet.add(new Book("B003", "C++ Cơ bản", "Phạm Văn An", 2008));
        bookSet.add(new Book("B004", "Cấu trúc dữ liệu", "Lê Hồng Phong", 2020));
        bookSet.add(new Book("B005", "Học máy", "Ngô Đức Thịnh", 2018));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập năm xuất bản tối thiểu: ");
        int filterYear = scanner.nextInt();

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : bookSet) {
            if (book.getYear() > filterYear) {
                filteredBooks.add(book);
            }
        }

        filteredBooks.sort(Comparator.comparing(Book::getTitle));

        System.out.println("\nDanh sách sách xuất bản sau năm " + filterYear + " (sắp xếp theo tên):");
        for (Book book : filteredBooks) {
            System.out.println(book);
        }
    }
}