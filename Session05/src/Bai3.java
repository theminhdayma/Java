import java.util.Scanner;

public class Bai3 {
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

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }

        System.out.printf("Có %d số chẵn trong mảng", count);
        sc.close();
    }
}
