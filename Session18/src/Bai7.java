import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        do {
            System.out.print("Nhập số phần tử của mảng: ");
            N = scanner.nextInt();
            if (N <= 0) {
                System.out.println("Giá trị phải là số nguyên dương. Nhập lại");
            }
        } while (N <= 0);

        int[] arr = new int[N];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Map<Integer, Integer> appearMap = new HashMap<>();
        for (int num : arr) {
            appearMap.put(num, appearMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(appearMap.entrySet());

        sortedList.sort(Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("Kết quả theo thứ tự số lần xuất hiện tăng dần:");
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        scanner.close();
    }
}
