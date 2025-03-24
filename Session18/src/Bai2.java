import java.util.HashMap;
import java.util.Map;

public class Bai2 {
    public static void main(String[] args) {
        Map<String, Integer> productPrices = Map.of(
                "Laptop", 1500,
                "Smartphone", 1000
        );

        String searchProduct = "Laptop";
        if (productPrices.containsKey(searchProduct)) {
            System.out.println(searchProduct + " có trong danh sách với giá: " + productPrices.get(searchProduct));
        } else {
            System.out.println(searchProduct + " không có trong danh sách.");
        }

        int searchPrice = 1000;
        boolean found = false;
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            if (entry.getValue() == searchPrice) {
                System.out.println(entry.getKey() + " có giá là " + searchPrice);
                found = true;
            }
        }

        if (!found) {
            System.out.println("\"Không có sản phẩm nào có giá trị \"" + searchPrice);
        }
    }
}