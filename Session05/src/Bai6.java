import java.util.Arrays;

public class Bai6 {
    public static void main(String[] args) {
        int[] markingArray = new int[1001];

        int[] originalArray = {1,2,3,4,5,6,4,2,7,9,2,5,8,0,8,3,4,6,16,3};

        for (int num : originalArray) {
            markingArray[num]++;
        }

        for (int num : markingArray) {
            System.out.print(num + " ");
        }

        int maxCount = 0;
        for (int count : markingArray) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println("Các phần tử xuất hiện nhiều nhất trong mảng:");
        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] == maxCount) {
                System.out.println("Phần tử: " + i + " xuất hiện " + maxCount + " lần");
            }
        }
    }
}
