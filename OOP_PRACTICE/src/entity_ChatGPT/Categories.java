package entity_ChatGPT;

import java.util.Scanner;

public class Categories implements IApp {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.id = idCounter++;
    }

    public Categories(String name, int priority, String description, boolean status) {
        this.id = idCounter++;
        setName(name);
        setPriority(priority);
        setDescription(description);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() >= 6 && name.length() <= 50) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Tên danh mục phải có từ 6-50 ký tự.");
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority >= 0) {
            this.priority = priority;
        } else {
            throw new IllegalArgumentException("Độ ưu tiên phải là số nguyên dương.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= 255) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Mô tả danh mục không được vượt quá 255 ký tự.");
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên danh mục (6-50 ký tự): ");
        while (true) {
            try {
                setName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập độ ưu tiên: ");
        while (true) {
            try {
                setPriority(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập mô tả (tối đa 255 ký tự): ");
        while (true) {
            try {
                setDescription(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Trạng thái danh mục (true: hoạt động, false: không hoạt động): ");
        while (true) {
            String inputStatus = scanner.nextLine().trim().toLowerCase();
            if (inputStatus.equals("true") || inputStatus.equals("false")) {
                setStatus(Boolean.parseBoolean(inputStatus));
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
