package Bai10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Số lượng không hợp lệ! Vui lòng nhập số dương.");
        }
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Đã cập nhật số lượng sản phẩm: " + product.getName());
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
        System.out.println("Đã thêm sản phẩm vào giỏ hàng: " + product.getName());
    }

    public void removeFromCart(String productId) throws ProductNotFoundException {
        boolean removed = cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
        if (!removed) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm trong giỏ hàng!");
        } else {
            System.out.println("Đã xóa sản phẩm khỏi giỏ hàng.");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
            return;
        }
        System.out.println("Giỏ hàng của bạn:");
        for (CartItem item : cartItems) {
            System.out.println(item);
        }
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống, không thể thanh toán!");
            return;
        }
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        System.out.println("Tổng tiền cần thanh toán: " + total + " VND");
    }
}
