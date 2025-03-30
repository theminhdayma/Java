import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        String inputFile = "inputBai3.txt";
        String outputFile = "copyBai3.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("Minh đẹp trai");
            System.out.println("Đã tạo file " + inputFile);
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file inputBai3.txt: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Đã sao chép nội dung từ " + inputFile + " sang " + outputFile);
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Nội dung của file " + outputFile + ": ");
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file copyBai3.txt: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}