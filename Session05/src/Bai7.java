public class Bai7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 9, 12, 13};
        int[] newArr = new int[arr.length];

        if (arr.length == 0) {
            System.out.printf("Mảng rỗng");
        } else {
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    newArr[index++] = arr[i];
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 1) {
                    newArr[index++] = arr[i];
                }
            }

            System.out.printf("Mảng sau khi sắp xếp là: ");
            for (int i = 0; i < newArr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
