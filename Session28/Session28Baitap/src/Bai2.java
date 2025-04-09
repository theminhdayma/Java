import java.sql.*;

public class Bai2 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/session28";
        String dbUser = "theminhdayma";
        String dbPassword = "123456";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Kết nối thành công!");

            System.out.println("Trạng thái auto-commit ban đầu: " + conn.getAutoCommit());
            conn.setAutoCommit(false);
            System.out.println("Auto-commit đã bị tắt.");

            String insertSQL1 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement stmt1 = conn.prepareStatement(insertSQL1);
            stmt1.setInt(1, 100);
            stmt1.setString(2, "Minh Test");
            stmt1.setString(3, "minh_test@gmail.com");
            stmt1.executeUpdate();
            System.out.println("INSERT hợp lệ thành công!");

            String insertSQL2 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement stmt2 = conn.prepareStatement(insertSQL2);
            stmt2.setInt(1, 100);
            stmt2.setString(2, "Trùng ID");
            stmt2.setString(3, "trungid@gmail.com");
            stmt2.executeUpdate();

            conn.commit();
            System.out.println("Cả hai INSERT thành công, đã commit.");

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());

            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback, không có dữ liệu nào được thêm.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Đã đóng kết nối.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try (Connection checkConn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String checkSQL = "SELECT * FROM users WHERE id = 100";
            ResultSet rs = checkConn.createStatement().executeQuery(checkSQL);

            if (rs.next()) {
                System.out.println("Dữ liệu vẫn tồn tại (rollback thất bại)");
            } else {
                System.out.println("Không có dữ liệu được thêm (rollback thành công)");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
