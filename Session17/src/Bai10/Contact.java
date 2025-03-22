package Bai10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Contact {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = idCounter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Số điện thoại: " + phoneNumber;
    }
}


