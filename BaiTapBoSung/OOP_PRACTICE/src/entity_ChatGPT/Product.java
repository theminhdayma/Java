package entity_ChatGPT;

import java.util.Scanner;

public class Product implements IApp {
    private String id;
    private String name;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {}

    public Product(String id, String name, float importPrice, float exportPrice, String title,
                   String description, int quantity, int categoryId, int status) {
        this.id = id;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
    }

    // Getters và Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }

    public double getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    @Override
    public void inputData(Scanner scanner) {
        this.id = inputString(scanner, "Nhập mã sản phẩm (5 ký tự, bắt đầu bằng 'C', 'E', 'T'):", "^[CET][A-Za-z0-9]{4}$");

        this.name = inputString(scanner, "Nhập tên sản phẩm (10-100 ký tự):", ".{10,100}");

        this.importPrice = inputFloat(scanner, "Nhập giá nhập (lớn hơn 0):", 0);

        double minExportPrice = importPrice * IApp.INTEREST;
        this.exportPrice = inputFloat(scanner, "Nhập giá xuất (>= " + minExportPrice + "):", minExportPrice);

        this.title = inputString(scanner, "Nhập tiêu đề sản phẩm (tối đa 200 ký tự):", ".{0,200}");

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine().trim();

        this.quantity = inputInteger(scanner, "Nhập số lượng sản phẩm (>= 0):", 0);

        this.categoryId = inputInteger(scanner, "Nhập mã danh mục:", Integer.MIN_VALUE);

        this.status = inputInteger(scanner, "Nhập trạng thái sản phẩm (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động):", 0, 2);
    }

    @Override
    public void displayData() {
        System.out.println("------------------------------------------");
        System.out.printf("Mã sản phẩm   : %s%n", id);
        System.out.printf("Tên sản phẩm  : %s%n", name);
        System.out.printf("Giá nhập      : %.2f%n", importPrice);
        System.out.printf("Giá xuất      : %.2f%n", exportPrice);
        System.out.printf("Tiêu đề       : %s%n", title);
        System.out.printf("Mô tả         : %s%n", description);
        System.out.printf("Số lượng      : %d%n", quantity);
        System.out.printf("Mã danh mục   : %d%n", categoryId);
        System.out.printf("Trạng thái    : %s%n", getStatusText());
    }

    private String getStatusText() {
        return switch (status) {
            case 0 -> "Hoạt động";
            case 1 -> "Hết hàng";
            default -> "Không hoạt động";
        };
    }

    // Hàm hỗ trợ nhập dữ liệu chung
    private String inputString(Scanner scanner, String prompt, String regex) {
        System.out.print(prompt + " ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.matches(regex)) return input;
            System.out.print("Dữ liệu không hợp lệ. Nhập lại: ");
        }
    }

    private int inputInteger(Scanner scanner, String prompt, int minValue) {
        return inputInteger(scanner, prompt, minValue, Integer.MAX_VALUE);
    }

    private int inputInteger(Scanner scanner, String prompt, int minValue, int maxValue) {
        System.out.print(prompt + " ");
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= minValue && value <= maxValue) return value;
            } else {
                scanner.next();
            }
            System.out.print("Dữ liệu không hợp lệ. Nhập lại: ");
        }
    }

    private double inputFloat(Scanner scanner, String prompt, double minValue) {
        System.out.print(prompt + " ");
        while (true) {
            if (scanner.hasNextFloat()) {
                double value = scanner.nextFloat();
                scanner.nextLine();
                if (value > minValue) return value;
            } else {
                scanner.next();
            }
            System.out.print("Dữ liệu không hợp lệ. Nhập lại: ");
        }
    }
}
