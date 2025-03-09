import java.util.Scanner;

public class Bai4 {
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

        for (int i = 0; i < N / 2; i++) {
            int temp = array[i];
            array[i] = array[N - i - 1];
            array[N - i - 1] = temp;
        }

        System.out.printf("Mảng sau khi đảo ngược: ");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
