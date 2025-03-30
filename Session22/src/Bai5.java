import java.io.*;

public class Bai5 {
    public static void main(String[] args) {
        String fileName = "inputBai5.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Văn Lâm\nTiến Linh\nXuân Son\nHoàng Đức\nVăn Hậu\n");
            System.out.println("Đã tạo file " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file inputBai5.txt: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String longestName = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > longestName.length()) {
                    longestName = line;
                }
            }
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên đó: " + longestName.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}