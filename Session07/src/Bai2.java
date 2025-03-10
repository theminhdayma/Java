public class Bai2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        System.out.println("Chuỗi ban đầu: " + sb);

        sb.delete(5, 10);
        System.out.println("Chuỗi sau khi xóa: " + sb);

        int startIndex = sb.indexOf("World");
        if (startIndex != -1) {
            sb.replace(startIndex, startIndex + 5, "Universe");
        }
        System.out.println("Chuỗi sau khi thay thế: " + sb);
    }
}
