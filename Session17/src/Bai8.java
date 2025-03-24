
public class Bai8 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 3, 5, 8, 3};
        int k = 10;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
                }
            }
        }
    }
}
