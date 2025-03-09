import java.lang.reflect.Array;
import java.util.Scanner;

public class Bai1 {
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

        int max = array[0];
        for (int i = 1; i < N; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.printf("giá trị lớn nhất trong mảng là: %d", max);

        sc.close();
    }
}
