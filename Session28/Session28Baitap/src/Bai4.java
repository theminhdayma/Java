

import java.sql.*;

public class Bai4 {
    public static void main(String[] args) {
        transferMoney(1, 2, 1000000);
    }

    public static void transferMoney(int fromAccId, int toAccId, double amount) {
        Connection connA = null;
        Connection connB = null;

        PreparedStatement deductStmt = null;
        PreparedStatement addStmt = null;
        ResultSet rs = null;

        try {
            connA = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taikhoana", "taikhoanA", "123456");
            connA.setAutoCommit(false);

            connB = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taikhoanb", "taikhoanB", "123456");
            connB.setAutoCommit(false);

            String checkSql = "SELECT balance FROM bank_accounts WHERE account_id = ?";
            PreparedStatement checkStmt = connA.prepareStatement(checkSql);
            checkStmt.setInt(1, fromAccId);
            rs = checkStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản gửi không tồn tại.");
            }

            double fromBalance = rs.getDouble("balance");
            if (fromBalance < amount) {
                throw new SQLException("Số dư không đủ để chuyển.");
            }

            String deductSql = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
            deductStmt = connA.prepareStatement(deductSql);
            deductStmt.setDouble(1, amount);
            deductStmt.setInt(2, fromAccId);
            deductStmt.executeUpdate();

            String addSql = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
            addStmt = connB.prepareStatement(addSql);
            addStmt.setDouble(1, amount);
            addStmt.setInt(2, toAccId);
            int updated = addStmt.executeUpdate();

            if (updated == 0) {
                throw new SQLException("Tài khoản nhận không tồn tại.");
            }

            connA.commit();
            connB.commit();
            System.out.println("Chuyển tiền thành công giữa hai ngân hàng!");

        } catch (SQLException e) {
            System.err.println("Lỗi khi chuyển tiền: " + e.getMessage());
            try {
                if (connA != null) connA.rollback();
                if (connB != null) connB.rollback();
                System.out.println("Đã rollback cả hai kết nối.");
            } catch (SQLException ex) {
                System.err.println("Lỗi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (deductStmt != null) deductStmt.close();
                if (addStmt != null) addStmt.close();
                if (connA != null) connA.close();
                if (connB != null) connB.close();
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}
