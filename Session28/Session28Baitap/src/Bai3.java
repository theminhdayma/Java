

import java.sql.*;

public class Bai3 {
    public static void main(String[] args) {
        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 200000;

        transferMoney(fromAccountId, toAccountId, amount);
    }

    public static void transferMoney(int fromId, int toId, double amount) {
        Connection conn = null;
        PreparedStatement deductStmt = null;
        PreparedStatement addStmt = null;
        PreparedStatement checkBalanceStmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/session28";
            String username = "theminhdayma";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);

            conn.setAutoCommit(false);

            String checkSql = "SELECT balance FROM accounts WHERE id = ?";
            checkBalanceStmt = conn.prepareStatement(checkSql);
            checkBalanceStmt.setInt(1, fromId);
            rs = checkBalanceStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Không tìm thấy tài khoản gửi.");
            }

            double fromBalance = rs.getDouble("balance");
            if (fromBalance < amount) {
                throw new SQLException("Số dư không đủ để chuyển tiền.");
            }

            String deductSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            deductStmt = conn.prepareStatement(deductSql);
            deductStmt.setDouble(1, amount);
            deductStmt.setInt(2, fromId);
            deductStmt.executeUpdate();

            String addSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            addStmt = conn.prepareStatement(addSql);
            addStmt.setDouble(1, amount);
            addStmt.setInt(2, toId);
            int updated = addStmt.executeUpdate();

            if (updated == 0) {
                throw new SQLException("Không tìm thấy tài khoản nhận.");
            }

            conn.commit();
            System.out.println("Chuyển tiền thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback(); // Nếu lỗi, rollback toàn bộ
                    System.out.println("Đã rollback do lỗi: " + e.getMessage());
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (checkBalanceStmt != null) checkBalanceStmt.close();
                if (deductStmt != null) deductStmt.close();
                if (addStmt != null) addStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                System.err.println("Lỗi khi đóng kết nối: " + closeEx.getMessage());
            }
        }
    }

}