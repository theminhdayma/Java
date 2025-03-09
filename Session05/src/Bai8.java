import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        do {
            System.out.print("Nhập số lượng phần tử của mảng: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Nhập lại!");
            }
        } while (n <= 0);

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            if (freq[i] == -1) continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    freq[j] = -1;
                }
            }
            freq[i] = count;
        }

        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] == 1) uniqueCount++;
        }

        if (uniqueCount == 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
            return;
        }

        int[] uniqueArr = new int[uniqueCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] == 1) {
                uniqueArr[index++] = arr[i];
            }
        }

        System.out.print("Mảng sau khi loại bỏ phần tử trùng lặp: ");
        for (int num : uniqueArr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
