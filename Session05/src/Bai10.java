import java.util.Scanner;

public class Bai10 {
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

        // Áp dụng thuật toán Kadane
        int maxSum = arr[0];
        int currentSum = 0;
        int maxElement = arr[0];
        boolean allNegative = true;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }

            if (arr[i] > 0) {
                allNegative = false;
            }

            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        if (allNegative) {
            System.out.println(maxElement + " là phẩn từ lớn nhất vì tất cả các giá trị trong mảng đều âm");
        } else {
            System.out.print(maxSum + " (Dãy con [");
            for (int i = start; i <= end; i++) {
                System.out.printf("%d\t", arr[i]);
            }
            System.out.println("] có tổng lớn nhất)");
        }

        sc.close();
    }
}