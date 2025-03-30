package Bai8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> validPhones = new ArrayList<>();
        List<String> invalidPhones = new ArrayList<>();

        System.out.println("Nhập danh sách số điện thoại: ");
        String input = sc.nextLine();

        String[] phoneNumbers = input.split(",");

        for (String phone : phoneNumbers) {
            phone = phone.trim();
            try {
                validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException | NumberFormatException e) {
                invalidPhones.add(phone + " - " + e.getMessage());
            }
        }

        System.out.println("\nDanh sách số điện thoại hợp lệ:");
        for (String phone : validPhones) {
            System.out.println(phone);
        }

        System.out.println("\nDanh sách số điện thoại không hợp lệ:");
        for (String error : invalidPhones) {
            System.out.println(error);
        }
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (!phone.matches("\\d+")) {
            throw new NumberFormatException("Số điện thoại chứa ký tự không hợp lệ!");
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Số điện thoại phải đúng 10 chữ số!");
        }
    }
}

