package entity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    private static Set<String> productIds = new HashSet<>();
    private static Set<String> productNames = new HashSet<>();

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        calProfit();

        productIds.add(productId);
        productNames.add(productName);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
        calProfit();
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
        calProfit();
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (4 ký tự, không trùng): ");
            String id = scanner.nextLine();
            if (id.length() == 4 && productIds.add(id)) {
                this.productId = id;
                break;
            }
            System.out.println("Mã sản phẩm không hợp lệ hoặc đã tồn tại!");
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự, không trùng): ");
            String name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 50 && productNames.add(name)) {
                this.productName = name;
                break;
            }
            System.out.println("Tên sản phẩm không hợp lệ hoặc đã tồn tại!");
        }

        while (true) {
            System.out.print("Nhập giá nhập (lớn hơn 0): ");
            float impPrice = Float.parseFloat(scanner.nextLine());
            if (impPrice > 0) {
                this.importPrice = impPrice;
                break;
            }
            System.out.println("Giá nhập phải lớn hơn 0!");
        }

        while (true) {
            System.out.print("Nhập giá xuất (lớn hơn ít nhất 20% so với giá nhập): ");
            float expPrice = Float.parseFloat(scanner.nextLine());
            if (expPrice >= importPrice * 1.2) {
                this.exportPrice = expPrice;
                break;
            }
            System.out.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập!");
        }

        calProfit();

        while (true) {
            System.out.print("Nhập số lượng sản phẩm (lớn hơn 0): ");
            int qty = Integer.parseInt(scanner.nextLine());
            if (qty > 0) {
                this.quantity = qty;
                break;
            }
            System.out.println("Số lượng phải lớn hơn 0!");
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái sản phẩm (true - Đang bán, false - Không bán): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("---------------------------------------------");
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + profit);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Trạng thái: " + (status ? "Đang bán" : "Không bán"));
    }
}

