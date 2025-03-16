package Bai8;

class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getDiscount() {
        return 0;
    }

    public double getFinalPrice() {
        return price - (price * getDiscount() / 100);
    }

    public double getDiscount(int quantity) {
        if (quantity > 100) {
            return 5;
        }
        return getDiscount();
    }

    public double getFinalPrice(int quantity) {
        double discount = getDiscount(quantity);
        return price * quantity - (price * quantity * discount / 100);
    }

    public void showInfo() {
        System.out.println("--------------------------");
        System.out.println("Sản phẩm: " + name);
        System.out.println("Gía: " + price + "VNĐ");
        System.out.println("giảm giá: " + getDiscount() + "%");
        System.out.println("Gía cuối cùng: " + getFinalPrice() + "VNĐ");
    }
}

