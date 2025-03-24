package entity;

import java.util.Scanner;

public class Product implements IApp {
    private String id;
    private String name;
    private float importPrice;
    private float exportPrice;
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

    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }

    public float getExportPrice() { return exportPrice; }
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
        System.out.print("Nhập mã sản phẩm (5 ký tự, bắt đầu bằng 'C', 'E', 'T'): ");
        while (true) {
            this.id = scanner.nextLine().trim();
            if (this.id.matches("^[CET][A-Za-z0-9]{4}$")) {
                break;
            }
            System.out.print("Mã sản phẩm không hợp lệ. Nhập lại: ");
        }

        System.out.print("Nhập tên sản phẩm (10-100 ký tự): ");
        while (true) {
            this.name = scanner.nextLine().trim();
            if (this.name.length() >= 10 && this.name.length() <= 100) {
                break;
            }
            System.out.print("Tên sản phẩm phải có từ 10 đến 100 ký tự. Nhập lại: ");
        }

        System.out.print("Nhập giá nhập: ");
        while (true) {
            if (scanner.hasNextFloat()) {
                this.importPrice = scanner.nextFloat();
                if (importPrice > 0) {
                    break;
                }
            }
            System.out.print("Giá nhập phải lớn hơn 0. Nhập lại: ");
            scanner.nextLine();
        }

        System.out.print("Nhập giá xuất (phải lớn hơn " + (importPrice * INTEREST) + "): ");
        while (true) {
            if (scanner.hasNextFloat()) {
                this.exportPrice = scanner.nextFloat();
                if (exportPrice >= importPrice * IApp.INTEREST) {
                    break;
                }
            }
            System.out.print("Giá xuất phải lớn hơn giá nhập * INTEREST. Nhập lại: ");
            scanner.nextLine();
        }
        scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

        System.out.print("Nhập tiêu đề sản phẩm (tối đa 200 ký tự): ");
        while (true) {
            this.title = scanner.nextLine().trim();
            if (this.title.length() <= 200) {
                break;
            }
            System.out.print("Tiêu đề không được quá 200 ký tự. Nhập lại: ");
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine().trim();

        System.out.print("Nhập số lượng sản phẩm: ");
        while (true) {
            if (scanner.hasNextInt()) {
                this.quantity = scanner.nextInt();
                if (quantity >= 0) {
                    break;
                }
            }
            System.out.print("Số lượng không hợp lệ. Nhập lại: ");
            scanner.nextLine();
        }

        System.out.print("Nhập mã danh mục: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Mã danh mục phải là số. Nhập lại: ");
            scanner.next();
        }
        this.categoryId = scanner.nextInt();

        System.out.print("Nhập trạng thái sản phẩm (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
        while (true) {
            if (scanner.hasNextInt()) {
                this.status = scanner.nextInt();
                if (status >= 0 && status <= 2) {
                    break;
                }
            }
            System.out.print("Trạng thái không hợp lệ. Nhập lại: ");
            scanner.nextLine();
        }
        scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.println("------------------------------------------");
        System.out.println("Mã sản phẩm: " + id);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Trạng thái: " + getStatusText());
    }

    private String getStatusText() {
        return switch (status) {
            case 0 -> "Hoạt động";
            case 1 -> "Hết hàng";
            default -> "Không hoạt động";
        };
    }
}