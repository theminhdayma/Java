package Bai6;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Nguyễn Thế Minh"),
                new Employee("Trần Đăng Thái"),
                new Employee(null)
        );

        addDepartmentWithEmployees("Phòng Nhân sự", employees);
    }

    public static void addDepartmentWithEmployees(String departmentName, List<Employee> employees) {
        Connection conn = null;
        PreparedStatement deptStmt = null;
        PreparedStatement empStmt = null;
        ResultSet generatedKeys = null;

        try {
            String url = "jdbc:mysql://localhost:3306/session28";
            String username = "theminhdayma";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);

            String insertDept = "INSERT INTO departments(name) VALUES (?)";
            deptStmt = conn.prepareStatement(insertDept, Statement.RETURN_GENERATED_KEYS);
            deptStmt.setString(1, departmentName);
            deptStmt.executeUpdate();

            generatedKeys = deptStmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new SQLException("Không thể lấy ID phòng ban vừa tạo.");
            }
            int deptId = generatedKeys.getInt(1);

            String insertEmp = "INSERT INTO employees(name, department_id) VALUES (?, ?)";
            empStmt = conn.prepareStatement(insertEmp);

            for (Employee emp : employees) {
                if (emp.getName() == null || emp.getName().trim().isEmpty()) {
                    throw new SQLException("Tên nhân viên không được để trống.");
                }

                empStmt.setString(1, emp.getName());
                empStmt.setInt(2, deptId);
                empStmt.executeUpdate();
            }
            conn.commit();
            System.out.println("Thêm phòng ban và nhân viên thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Rollback hoàn tất.");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (deptStmt != null) deptStmt.close();
                if (empStmt != null) empStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}
