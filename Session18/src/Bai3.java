import java.util.LinkedHashMap;
import java.util.Map;

public class Bai3 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> productPrices = new LinkedHashMap<>();

        productPrices.put("Laptop", 1500);
        productPrices.put("Smartphone", 1000);

        System.out.println("Danh sách sản phẩm ban đầu:");
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        productPrices.put("Laptop", 1400);
        System.out.println("\nSau khi cập nhật giá Laptop:");
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        productPrices.remove("Smartphone");
        System.out.println("\nSau khi xóa 1 sản phẩm:");
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
