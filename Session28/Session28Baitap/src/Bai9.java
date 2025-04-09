import java.sql.*;

public class Bai9 {
    public static void placeBid(int userId, int auctionId, double bidAmount) {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/session28";
            String username = "theminhdayma";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement checkUser = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            checkUser.setInt(1, userId);
            ResultSet rsUser = checkUser.executeQuery();

            if (!rsUser.next()) {
                logFailedBid(conn, auctionId, userId, bidAmount, "Người dùng không tồn tại");
                conn.rollback();
                System.out.println("Người dùng không tồn tại.");
                return;
            }

            double userBalance = rsUser.getDouble("balance");
            if (userBalance < bidAmount) {
                logFailedBid(conn, auctionId, userId, bidAmount, "Số dư không đủ");
                conn.rollback();
                System.out.println("Số dư không đủ.");
                return;
            }

            PreparedStatement checkAuction = conn.prepareStatement("SELECT * FROM auctions WHERE auction_id = ? AND status = 'OPEN' FOR UPDATE");
            checkAuction.setInt(1, auctionId);
            ResultSet rsAuction = checkAuction.executeQuery();

            if (!rsAuction.next()) {
                logFailedBid(conn, auctionId, userId, bidAmount, "Phiên đấu giá không tồn tại hoặc đã đóng");
                conn.rollback();
                System.out.println("Phiên đấu giá không tồn tại hoặc đã đóng.");
                return;
            }

            double currentHighestBid = rsAuction.getDouble("highest_bid");
            if (bidAmount <= currentHighestBid) {
                logFailedBid(conn, auctionId, userId, bidAmount, "Giá đặt thấp hơn giá cao nhất hiện tại");
                conn.rollback();
                System.out.println("Giá đặt chưa đủ cao.");
                return;
            }

            PreparedStatement updateAuction = conn.prepareStatement("UPDATE auctions SET highest_bid = ? WHERE auction_id = ?");
            updateAuction.setDouble(1, bidAmount);
            updateAuction.setInt(2, auctionId);
            updateAuction.executeUpdate();

            PreparedStatement updateBalance = conn.prepareStatement("UPDATE user SET balance = balance - ? WHERE user_id = ?");
            updateBalance.setDouble(1, bidAmount);
            updateBalance.setInt(2, userId);
            updateBalance.executeUpdate();

            PreparedStatement insertBid = conn.prepareStatement("INSERT INTO bids (auction_id, user_id, bid_amount) VALUES (?, ?, ?)");
            insertBid.setInt(1, auctionId);
            insertBid.setInt(2, userId);
            insertBid.setDouble(3, bidAmount);
            insertBid.executeUpdate();

            conn.commit();
            System.out.println("Đặt giá thành công!");

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
                System.out.println("Lỗi xảy ra, rollback!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Lỗi SQL: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng kết nối: " + e.getMessage());
            }
        }
    }

    private static void logFailedBid(Connection conn, int auctionId, int userId, double bidAmount, String reason) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO failed_bids (auction_id, user_id, bid_amount, reason) VALUES (?, ?, ?, ?)");
        ps.setInt(1, auctionId);
        ps.setInt(2, userId);
        ps.setDouble(3, bidAmount);
        ps.setString(4, reason);
        ps.executeUpdate();
    }

    public static void main(String[] args) {
        placeBid(1, 1, 1000);

        placeBid(2, 1, 1100);

        placeBid(3, 1, 9999999);
    }
}
