import java.io.*;

public class Bai6 {
    public static void main(String[] args) {
        String inputFile = "inputBai6.txt";
        String outputFile = "copyBai6.txt";

        // Tạo file input.txt với nội dung mẫu
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("iart pẹđ hniM");
            System.out.println("Đã tạo file " + inputFile);
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file inputBai6.txt: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String reversedContent = content.reverse().toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(reversedContent);
            System.out.println("Đã ghi nội dung đảo ngược vào file " + outputFile);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file copyBai6.txt: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            System.out.println("Nội dung file copyBai6.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file copyBai6.txt: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}