package Bai4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "student.txt";
        Student student = new Student("Nguyen Thế Minh", 20, 9);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file " + fileName);
        } catch (IOException e) {
            System.out.println( e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file " + fileName);
            System.out.println("Thông tin đối tượng: " + readStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
