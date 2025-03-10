public class Bai6 {
    public static void main(String[] args) {
        String text = "Hello";

        long startTime = System.currentTimeMillis();
        String str = text;
        for (int i = 0; i < 100000; i++) {
            str += " World";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < 100000; i++) {
            sb.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer(text);
        for (int i = 0; i < 100000; i++) {
            sbf.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: " + (endTime - startTime) + "ms");
    }
}
