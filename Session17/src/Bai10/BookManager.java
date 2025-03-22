package Bai10;

import java.util.*;

public class BookManager {
    private Set<Contact> contacts = new TreeSet<>(Comparator.comparing(Contact::getName));
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Contact> contactMap = new HashMap<>();

    public void addContact() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        if (contactMap.containsKey(phoneNumber)) {
            System.out.println("Số điện thoại đã tồn tại trong danh bạ!");
            return;
        }

        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        contactMap.put(phoneNumber, newContact);
        System.out.println("Đã thêm liên lạc thành công.");
    }

    public void removeContact() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String phoneNumber = scanner.nextLine();

        Contact toRemove = contactMap.remove(phoneNumber);
        if (toRemove != null) {
            contacts.remove(toRemove);
            System.out.println("Đã xóa liên lạc.");
        } else {
            System.out.println("Không tìm thấy số điện thoại trong danh bạ.");
        }
    }

    public void searchContact() {
        System.out.print("Nhập số điện thoại cần tìm: ");
        String phoneNumber = scanner.nextLine();

        Contact found = contactMap.get(phoneNumber);
        if (found != null) {
            System.out.println("Tìm thấy: " + found);
        } else {
            System.out.println("Không tìm thấy số điện thoại trong danh bạ.");
        }
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            System.out.println("Danh bạ hiện có:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ DANH BẠ =====");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addContact();
                    case 2 -> removeContact();
                    case 3 -> searchContact();
                    case 4 -> showContacts();
                    case 5 -> System.out.println("Thoát!");
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                choice = -1;
            }
        } while (choice != 5);
    }

}

