import java.sql.*;

public class Bai7 {
    public static void main(String[] args) throws Exception {
        testIsolation(Connection.TRANSACTION_READ_UNCOMMITTED, "READ_UNCOMMITTED");
        testIsolation(Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED");
        testIsolation(Connection.TRANSACTION_REPEATABLE_READ, "REPEATABLE_READ");
        testIsolation(Connection.TRANSACTION_SERIALIZABLE, "SERIALIZABLE");
    }

    public static void testIsolation(int level, String levelName) {
        System.out.println("Kểm tra: " + levelName);

        Connection conn1 = null;
        Connection conn2 = null;

        try {
            String url1 = "jdbc:mysql://localhost:3306/session28";
            String username1 = "theminhdayma";
            String password1 = "123456";
            conn1 = DriverManager.getConnection(url1, username1, password1);

            String url2 = "jdbc:mysql://localhost:3306/session28";
            String username2 = "theminhdayma";
            String password2 = "123456";
            conn2 = DriverManager.getConnection(url2, username2, password2);

            conn1.setAutoCommit(false);
            conn1.setTransactionIsolation(level);

            conn2.setAutoCommit(false);
            String insert = "INSERT INTO orders1(customer_name, status) VALUES ('Khách hàng A', 'PENDING')";
            PreparedStatement ps2 = conn2.prepareStatement(insert);
            ps2.executeUpdate();
            System.out.println("Connection 2: Đã INSERT nhưng chưa commit.");

            String select = "SELECT * FROM orders1";
            PreparedStatement ps1 = conn1.prepareStatement(select);
            ResultSet rs1 = ps1.executeQuery();

            System.out.println("Connection 1: Kết quả SELECT:");
            while (rs1.next()) {
                System.out.printf("- order_id: %d, customer_name: %s, status: %s\n",
                        rs1.getInt("order_id"),
                        rs1.getString("customer_name"),
                        rs1.getString("status"));
            }

            System.out.println("-> Ghi nhận: " + levelName +
                    (rs1.isBeforeFirst() ? " CÓ " : " KHÔNG ") + " đọc được dữ liệu chưa commit.");

            conn2.rollback();
            conn1.rollback();

        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        } finally {
            try {
                if (conn1 != null) conn1.close();
                if (conn2 != null) conn2.close();
            } catch (SQLException e) {
                System.err.println("Lỗi đóng kết nối: " + e.getMessage());
            }
        }
    }
}
