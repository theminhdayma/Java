import java.util.Map;
import java.util.TreeMap;

public class Bai4 {
    public static void main(String[] args) {
        TreeMap<String, Integer> employeeSalaries = new TreeMap<>();

        employeeSalaries.put("NV101", 10000);
        employeeSalaries.put("NV102", 5000);
        employeeSalaries.put("NV103", 7000);
        employeeSalaries.put("NV104", 8000);
        employeeSalaries.put("NV105", 9000);

        System.out.println("Danh sách nhân viên:");
        for (Map.Entry<String, Integer> entry : employeeSalaries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        employeeSalaries.put("NV103", 8500);
        System.out.println("\nSau khi cập nhật lương:");
        for (Map.Entry<String, Integer> entry : employeeSalaries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        employeeSalaries.remove("NV103");
        System.out.println("\nSau khi xóa 1 nhân viên:");
        for (Map.Entry<String, Integer> entry : employeeSalaries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}