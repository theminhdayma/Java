import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[0];
        int n = 0;
        int choice;

        do {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp mảng giảm dần (bubble sort)");
            System.out.println("6. Đếm số lượng số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp mảng theo yêu cầu");
            System.out.println("8. Chèn giá trị m vào mảng (sắp xếp giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số phần tử của mảng (n <= 100): ");
                    n = scanner.nextInt();
                    arr = new int[n];
                    System.out.println("Nhập các phần tử của mảng: ");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Các phần tử của mảng: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    int sum = 0, count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    System.out.println("Trung bình các phần tử dương: " + (count == 0 ? 0 : (double) sum / count));
                    break;
                case 4:
                    System.out.print("Nhập giá trị k: ");
                    int k = scanner.nextInt();
                    System.out.print("Các vị trí của " + k + ": ");
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == k) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] < arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp giảm dần.");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    break;
                case 6:
                    int primeCount = 0;
                    for (int i = 0; i < n; i++) {
                        boolean isPrime = arr[i] > 1;
                        for (int j = 2; j * j <= arr[i]; j++) {
                            if (arr[i] % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) primeCount++;
                    }
                    System.out.println("Số lượng số nguyên tố: " + primeCount);
                    break;
                case 7:
                    int[] evenDiv3 = new int[arr.length];
                    int[] oddDiv3 = new int[arr.length];
                    int[] others = new int[arr.length];
                    int evenCount = 0, oddCount = 0, otherCount = 0;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            evenDiv3[evenCount++] = arr[i];
                        } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                            oddDiv3[oddCount++] = arr[i];
                        } else {
                            others[otherCount++] = arr[i];
                        }
                    }

                    for (int i = 0; i < evenCount - 1; i++) {
                        for (int j = i + 1; j < evenCount; j++) {
                            if (evenDiv3[i] > evenDiv3[j]) {
                                int temp = evenDiv3[i];
                                evenDiv3[i] = evenDiv3[j];
                                evenDiv3[j] = temp;
                            }
                        }
                    }

                    for (int i = 0; i < otherCount - 1; i++) {
                        for (int j = i + 1; j < otherCount; j++) {
                            if (others[i] > others[j]) {
                                int temp = others[i];
                                others[i] = others[j];
                                others[j] = temp;
                            }
                        }
                    }

                    for (int i = 0; i < oddCount - 1; i++) {
                        for (int j = i + 1; j < oddCount; j++) {
                            if (oddDiv3[i] < oddDiv3[j]) {
                                int temp = oddDiv3[i];
                                oddDiv3[i] = oddDiv3[j];
                                oddDiv3[j] = temp;
                            }
                        }
                    }

                    int index = 0;
                    for (int i = 0; i < evenCount; i++) {
                        arr[index++] = evenDiv3[i];
                    }
                    for (int i = 0; i < otherCount; i++) {
                        arr[index++] = others[i];
                    }
                    for (int i = 0; i < oddCount; i++) {
                        arr[index++] = oddDiv3[i];
                    }

                    System.out.print("Mảng sau khi sắp xếp: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Nhập giá trị m cần chèn: ");
                    int m = scanner.nextInt();

                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] < arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }

                    int[] newArr = new int[n + 1];
                    int i, j;

                    for (i = 0; i < n && arr[i] > m; i++) {
                        newArr[i] = arr[i];
                    }

                    newArr[i] = m;

                    for (j = i; j < n; j++) {
                        newArr[j + 1] = arr[j];
                    }

                    arr = newArr;
                    n++;

                    System.out.print("Mảng sau khi chèn: ");
                    for (int num : arr) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 9);
        scanner.close();
    }
}
