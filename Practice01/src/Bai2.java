import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;

        System.out.print("Nhập số dòng n: ");
        n = scanner.nextInt();
        System.out.print("Nhập số cột m: ");
        m = scanner.nextInt();

        int[][] array = new int[n][m];

        int choice;
        do {
            System.out.println("*************** MENU ***************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng trên biên, đường chéo chính, đường chéo phụ");
            System.out.println("5. Sắp xếp tăng dần theo cột của mảng");
            System.out.println("6. In các số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp giảm dần trên đường chéo chính");
            System.out.println("8. Chèn mảng một chiều vào một dòng của mảng hai chiều");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập giá trị mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("array[%d][%d] = ", i, j);
                            array[i][j] = scanner.nextInt();
                        }
                    }
                    break;

                case 2:
                    System.out.println("Mảng theo ma trận:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(array[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (array[i][j] % 2 == 0 && array[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng phần tử chia hết cho 2 và 3: " + count);
                    break;

                case 4:
                    int sum = 0;
                    System.out.println("Các phần tử trên biên, đường chéo chính và phụ:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1 || i == j || i + j == n - 1) {
                                System.out.print(array[i][j] + " ");
                                sum += array[i][j];
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Tổng các phần tử trên biên và đường chéo: " + sum);
                    break;

                case 5:
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n - 1; i++) {
                            for (int k = i + 1; k < n; k++) {
                                if (array[i][j] > array[k][j]) {
                                    int temp = array[i][j];
                                    array[i][j] = array[k][j];
                                    array[k][j] = temp;
                                }
                            }
                        }
                    }

                    System.out.println("Maảng sau khi sắp xêp:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(array[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 6:
                    System.out.println("Các số nguyên tố trong mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (isPrime(array[i][j])) {
                                System.out.print(array[i][j] + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Sắp xếp đường chéo chính giảm dần:");
                    for (int i = 0; i < Math.min(n, m) - 1; i++) {
                        for (int j = i + 1; j < Math.min(n, m); j++) {
                            if (array[i][i] < array[j][j]) {
                                int temp = array[i][i];
                                array[i][i] = array[j][j];
                                array[j][j] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp :");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(array[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 8:
                    System.out.print("Nhập số phần tử của mảng 1 chiều: ");
                    int size = scanner.nextInt();
                    int[] oneDArray = new int[size];

                    System.out.println("Nhập giá trị mảng 1 chiều:");
                    for (int i = 0; i < size; i++) {
                        oneDArray[i] = scanner.nextInt();
                    }

                    System.out.print("Nhập chỉ số dòng muốn chèn: ");
                    int rowIndex = scanner.nextInt();

                    if (rowIndex >= 0 && rowIndex < n && size == m) {
                        for (int j = 0; j < m; j++) {
                            array[rowIndex][j] = oneDArray[j];
                        }
                        System.out.println("Mảng sau khi chèn:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.print(array[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Chỉ số dòng hoặc kích thước mảng không hợp lệ.");
                    }
                    break;

                case 9:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice != 9);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
