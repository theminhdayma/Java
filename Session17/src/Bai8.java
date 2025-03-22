import java.util.*;

public class Bai8 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 3, 5, 8, 3};
        int k = 10;

        List<int[]> pairs = findPairs(arr, k);

        System.out.print("Các cặp số có tổng bằng " + k + ": ");
        for (int[] pair : pairs) {
            System.out.print("(" + pair[0] + ", " + pair[1] + ") ");
        }
    }

    public static List<int[]> findPairs(int[] arr, int k) {
        Set<String> uniquePairs = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    int a = Math.min(arr[i], arr[j]);
                    int b = Math.max(arr[i], arr[j]);
                    String pairKey = a + "," + b;

                    if (!uniquePairs.contains(pairKey)) {
                        uniquePairs.add(pairKey);
                        result.add(new int[]{a, b});
                    }
                }
            }
        }

        result.sort(Comparator.comparingInt(o -> o[0]));

        return result;
    }
}
