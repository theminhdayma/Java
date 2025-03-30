package Bai9;

import java.io.*;
import java.util.*;

class BookManager {
    public List<Book> books;
    private final String filePath = "books.dat";

    public BookManager() {
        this.books = readBooksFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        writeBooksToFile();
        System.out.println("Đã thêm sách: " + book);
    }

    public void updateBook(int id) {
        Scanner scanner = new Scanner(System.in);
        for (Book book : books) {
            if (book.getId() == id) {
                int choice;
                do {
                    System.out.println("Cập nhật thông tin sách:");
                    System.out.println("1. Tên sách");
                    System.out.println("2. Tác giả");
                    System.out.println("3. Nhà xuất bản");
                    System.out.println("4. Giá");
                    System.out.println("5. Thoát cập nhật");
                    System.out.print("Chọn: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập tên sách mới: ");
                            book.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập tác giả mới: ");
                            book.setAuthor(scanner.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhập nhà xuất bản mới: ");
                            book.setPublisher(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhập giá mới: ");
                            book.setPrice(scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.println("Cập nhật hoàn tất.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 5");
                    }
                } while (choice != 5);

                writeBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID: " + id);
    }


    public void deleteBook(int id) {
        if (books.removeIf(book -> book.getId() == id)) {
            writeBooksToFile();
            System.out.println("Đã xóa sách có ID: " + id);
        } else {
            System.out.println("Không tìm thấy sách có ID: " + id);
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách trống.");
            return;
        }
        System.out.println("Danh sách sách:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void writeBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Book> readBooksFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

