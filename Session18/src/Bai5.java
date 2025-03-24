import java.util.*;

public class Bai5 {
    public static void main(String[] args) {
        Map<String, Integer> productPrices = new HashMap<>();

        productPrices.put("Laptop", 1500);
        productPrices.put("Điện thoại", 800);
        productPrices.put("TV", 600);
        productPrices.put("Tủ lạnh", 300);
        productPrices.put("Điều hòa", 100);
        productPrices.put("Máy giặt", 50);

        List<Map.Entry<String, Integer>> filteredProducts = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            if (entry.getValue() >= 500 && entry.getValue() <= 1500) {
                filteredProducts.add(entry);
            }
        }

        filteredProducts.sort(Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("Danh sách sản phẩm trong khoảng giá 500 - 1500, sắp xếp theo giá:");
        for (Map.Entry<String, Integer> entry : filteredProducts) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }
    }
}