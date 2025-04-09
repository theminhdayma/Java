package Bai5;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OrderDetails> details = Arrays.asList(
                new OrderDetails("Sản phẩm 1", 2),
                new OrderDetails("Sản phẩm 2", 5),
                new OrderDetails("Sản phẩm lỗi", -3)
        );

        createOrderWithDetails("Nguyễn Văn A", details);
    }

    public static void createOrderWithDetails(String customerName, List<OrderDetails> details) {
        Connection conn = null;
        PreparedStatement orderStmt = null;
        PreparedStatement detailStmt = null;
        ResultSet generatedKeys = null;

        try {
            String url = "jdbc:mysql://localhost:3306/session28";
            String username = "theminhdayma";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);

            String insertOrderSql = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";
            orderStmt = conn.prepareStatement(insertOrderSql, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setString(1, customerName);
            orderStmt.setDate(2, Date.valueOf(LocalDate.now()));
            orderStmt.executeUpdate();

            generatedKeys = orderStmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new SQLException("Không thể lấy order_id vừa tạo.");
            }
            int orderId = generatedKeys.getInt(1);

            String insertDetailSql = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
            detailStmt = conn.prepareStatement(insertDetailSql);

            for (OrderDetails d : details) {
                if (d.getQuantity() <= 0) {
                    throw new SQLException("Số lượng phải lớn hơn 0 cho sản phẩm: " + d.getProductName());
                }

                detailStmt.setInt(1, orderId);
                detailStmt.setString(2, d.getProductName());
                detailStmt.setInt(3, d.getQuantity());
                detailStmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Tạo đơn hàng thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi khi tạo đơn hàng: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
                System.out.println("Rollback hoàn tất.");
            } catch (SQLException ex) {
                System.err.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (orderStmt != null) orderStmt.close();
                if (detailStmt != null) detailStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}
