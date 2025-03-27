package Bai3;

import java.util.Optional;

class User {
    private String name;
    private Optional<String> phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }

    public void printInfo() {
        System.out.println("Tên: " + name + ", SĐT: " + phoneNumber.orElse("Không có"));
    }
}