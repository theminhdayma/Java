package Bai8;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Electronics("TV", 30000000),
                new Clothing("Áo phông", 200000),
                new Food("Pizza", 150000)
        };

        for (Product p : products) {
            p.showInfo();
        }

        for (Product p : products) {
            System.out.println(p.name + " - giá của số lượng sản phẩm lớn: " + p.getFinalPrice(150) + "VNĐ");
        }
    }
}

