
package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator<T> {
    public static String validateID(String message, Scanner scanner, String type) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Không được để trống!");
                continue;
            }

            boolean isValid = switch (type.toLowerCase()) {
                case "course" -> Pattern.matches("^C\\w{4}$", input);
                case "student" -> Pattern.matches("^SV\\w{3}$", input);
                default -> false;
            };

            if (!isValid) {
                System.out.println("ID không hợp lệ. Vui lòng nhập lại!");
            } else {
                break;
            }
        }
        return input;
    }
    public static String validateString(String message, Scanner scanner, StringRule rule) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Không được để trống!");
                }
                if (!rule.isValidString(input)) {
                    throw new IllegalArgumentException("Số lượng ký tự không hợp lệ, yêu cầu nhập lại!");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean validateBoolean(String message, Scanner scanner) {
        System.out.print(message + " (Nhập true/false)");
        while (true) {
            try {
                String input = scanner.nextLine().trim().toLowerCase();
                if (!input.equals("true") && !input.equals("false")) {
                    throw new InputMismatchException("Không phải giá trị boolean hợp lệ, yêu cầu nhập lại (true/false)!");
                }
                return Boolean.parseBoolean(input);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static String validatePhone(String message, Scanner scanner) {
        System.out.print(message);
        String regex = "^(0[35789][0-9]{8})$";

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException("Không được để trống!");
                }
                if (!input.matches(regex)) {
                    throw new InputMismatchException("Số điện thoại không hợp lệ, yêu cầu nhập lại!");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static String validateEmail(String message, Scanner scanner) {
        System.out.print(message);
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException("Không được để trống!");
                }
                if (!pattern.matcher(input).matches()) {
                    throw new InputMismatchException("Email không hợp lệ, yêu cầu nhập lại!");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static String validateStatusEnum(String message, Scanner scanner, String type) {
        while (true) {
            System.out.println(message);

            switch (type.toLowerCase().trim()) {
                case "sex":
                    System.out.println("1. MALE");
                    System.out.println("2. FEMALE");
                    System.out.println("3. OTHER");
                    break;

                case "statusregistration":
                    System.out.println("1. PENDING");
                    System.out.println("2. ENROLLED");
                    System.out.println("3. DROPPED");
                    break;

                case "statusclass":
                    System.out.println("1. PENDING");
                    System.out.println("2. PROGRESS");
                    System.out.println("3. CLOSE");
                    break;

                default:
                    System.out.println("Loại không hợp lệ.");
                    return null;
            }

            System.out.print("Vui lòng chọn (1-3): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return switch (type.toLowerCase()) {
                        case "sex" -> "MALE";
                        case "statusregistration", "statusclass" -> "PENDING";
                        default -> null;
                    };

                case "2":
                    return switch (type.toLowerCase()) {
                        case "sex" -> "FEMALE";
                        case "statusregistration" -> "ENROLLED";
                        case "statusclass" -> "PROGRESS";
                        default -> null;
                    };

                case "3":
                    return switch (type.toLowerCase()) {
                        case "sex" -> "OTHER";
                        case "statusregistration" -> "DROPPED";
                        case "statusclass" -> "CLOSE";
                        default -> null;
                    };

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn 1, 2 hoặc 3.");
            }
        }
    }

    public static int validateInt(String message, Scanner scanner, int min) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min) return value;
                System.out.println("Giá trị phải >= " + min);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    public static double validateDouble(String message, Scanner scanner, double min) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= min) return value;
                System.out.println("Giá trị phải >= " + min);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

}
