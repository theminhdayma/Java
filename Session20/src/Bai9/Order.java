package Bai9;

import java.time.LocalDate;
import java.util.Optional;

public class Order {
    private int id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    public Order(int id, String customerName, LocalDate createdDate, LocalDate deliveryDate) {
        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    public String toDisplayString() {
        return String.format("ID: %-3d | KH: %-7s | Đặt: %s | Giao: %s",
                id, customerName, createdDate, deliveryDate.map(LocalDate::toString).orElse("Chưa giao"));
    }
}


