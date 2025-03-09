import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào số giá trị trong mảng: ");
        N = sc.nextInt();
        int[] array = new int[N];
        System.out.printf("Nập các phần tử cho mảng : ");
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        int max = -1;
        int min = -1;
        for (int i = 0; i < N; i++) {
            if (array[i] % 2 == 1 && array[i] > 0) {
                if (array[i] > max || max == -1) {
                    max = array[i];
                }
                if (array[i] < min || min == -1) {
                    min = array[i];
                }
            }
        }

        if (max == -1 || min == -1) {
            System.out.println("Không có phần tử lẻ nguyên dương trong mảng");

        } else {
            System.out.println("Phần tử lẻ nguyên dương lớn nhất: " + max);
            System.out.println("Phần tử lẻ nguyên dương nhỏ nhất: " + min);
        }

        sc.close();
    }
}
