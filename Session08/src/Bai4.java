public class Bai4 {
    public static void main(String[] args) {
        String chuoiBanDau = "abcdefghij".repeat(100000);

        System.out.println("🔹 Kiểm tra với StringBuilder...");
        long thoiGianBatDau = System.nanoTime();
        kiemTraStringBuilder(chuoiBanDau);
        long thoiGianKetThuc = System.nanoTime();
        System.out.println("⏳ Thời gian thực thi của StringBuilder: " + (thoiGianKetThuc - thoiGianBatDau) / 1_000_000 + " ms\n");

        System.out.println("🔹 Kiểm tra với StringBuffer...");
        thoiGianBatDau = System.nanoTime();
        kiemTraStringBuffer(chuoiBanDau);
        thoiGianKetThuc = System.nanoTime();
        System.out.println("⏳ Thời gian thực thi của StringBuffer: " + (thoiGianKetThuc - thoiGianBatDau) / 1_000_000 + " ms");
    }

    private static void kiemTraStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);

        sb.reverse();

        sb.insert(sb.length() / 2, "CHEN_CHUOI");

        sb.delete(sb.length() / 4, sb.length() / 3);

        sb.replace(sb.length() / 5, sb.length() / 4, "THAY_THE");
    }

    private static void kiemTraStringBuffer(String str) {
        StringBuffer sb = new StringBuffer(str);

        sb.reverse();

        sb.insert(sb.length() / 2, "CHEN_CHUOI");

        sb.delete(sb.length() / 4, sb.length() / 3);

        sb.replace(sb.length() / 5, sb.length() / 4, "THAY_THE");
    }
}
