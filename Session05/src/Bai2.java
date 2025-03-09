import java.util.Scanner;

public class Bai2 {
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

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
        }

        System.out.printf("Tổng các giá trị trong mảng là: %d", sum);

        sc.close();
    }
}
