import java.util.ArrayList;
import java.util.Iterator;

public class Bai1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Nguyễn Văn A");
        students.add("Trần Thị B");
        students.add("Lê Văn C");
        students.add("Phạm Thị D");
        students.add("Đỗ Mạnh E");

        System.out.println("Duyệt danh sách bằng vòng lặp for:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        System.out.println("\nDuyệt danh sách bằng vòng lặp foreach:");
        for(String student : students) {
            System.out.println(student);
        }

        System.out.println("\nDuyệt danh sách bằng Iterator:");
        Iterator<String> student = students.iterator();
        while(student.hasNext()) {
            System.out.println(student.next());
        }
    }
}
