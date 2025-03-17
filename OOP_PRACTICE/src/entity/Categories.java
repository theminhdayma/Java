package entity;

import java.util.Scanner;

public class Categories implements IApp {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.id = idCounter++;
    }

    public Categories(String name, int priority, String description, boolean status) {
        this.id = idCounter++;
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên danh mục (6-50 ký tự): ");
            String inputName = scanner.nextLine();
            if (inputName.length() >= 6 && inputName.length() <= 50) {
                this.name = inputName;
                break;
            } else {
                System.out.println("Tên danh mục phải có từ 6-50 ký tự.");
            }
        }

        while (true) {
            System.out.print("Nhập độ ưu tiên: ");
            try {
                int inputPriority = Integer.parseInt(scanner.nextLine());
                if (inputPriority >= 0) {
                    this.priority = inputPriority;
                    break;
                } else {
                    System.out.println("Độ ưu tiên phải là số nguyên dương.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập mô tả (tối đa 255 ký tự): ");
            String inputDescription = scanner.nextLine();
            if (inputDescription.length() <= 255) {
                this.description = inputDescription;
                break;
            } else {
                System.out.println("Mô tả danh mục không được vượt quá 255 ký tự.");
            }
        }

        while (true) {
            System.out.print("Trạng thái danh mục (true: hoạt động, false: không hoạt động): ");
            String inputStatus = scanner.nextLine();
            if (inputStatus.equalsIgnoreCase("true") || inputStatus.equalsIgnoreCase("false")) {
                this.status = Boolean.parseBoolean(inputStatus);
                break;
            } else {
                System.out.println("Vui lòng nhập true hoặc false.");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: " + id);
        System.out.println("Tên danh mục: " + name);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
    }
}
