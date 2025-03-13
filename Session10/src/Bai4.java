class Book {
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Giá không hợp lệ");
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public void displayBookInfo() {
        System.out.println("Thông tin sách: " + title + " - " + author + " - " + price + " VNĐ");
    }

}

public class Bai4 {
    public static void main(String[] args) {
        Book myBook = new Book("Đắc nhân tâm", "Dale Carnegie", 200000);
        myBook.displayBookInfo();

        myBook.setTitle("Nhà Giả Kim");
        myBook.setAuthor("Paulo Coelho");
        myBook.setPrice(-100000);

        myBook.displayBookInfo();
    }
}
