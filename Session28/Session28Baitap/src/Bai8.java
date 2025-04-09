
import java.sql.*;

public class Bai8 {
    public static void bookRoom(int customerId, int roomId) {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/session28";
            String username = "theminhdayma";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);

            PreparedStatement checkCustomer = conn.prepareStatement("SELECT * FROM customers WHERE customer_id = ?");
            checkCustomer.setInt(1, customerId);
            ResultSet rsCustomer = checkCustomer.executeQuery();
            if (!rsCustomer.next()) {
                logFailedBooking(conn, "UNKNOWN", roomId, "Khách hàng không tồn tại");
                conn.rollback();
                System.out.println("Khách hàng không tồn tại.");
                return;
            }
            String customerName = rsCustomer.getString("name");

            PreparedStatement checkRoom = conn.prepareStatement("SELECT * FROM rooms WHERE room_id = ? AND availability = TRUE");
            checkRoom.setInt(1, roomId);
            ResultSet rsRoom = checkRoom.executeQuery();
            if (!rsRoom.next()) {
                logFailedBooking(conn, customerName, roomId, "Phòng đã được đặt");
                conn.rollback();
                System.out.println("Phòng không khả dụng.");
                return;
            }

            PreparedStatement updateRoom = conn.prepareStatement("UPDATE rooms SET availability = FALSE WHERE room_id = ?");
            updateRoom.setInt(1, roomId);
            updateRoom.executeUpdate();

            PreparedStatement insertBooking = conn.prepareStatement("INSERT INTO bookings (customer_id, room_id, booking_date, status) VALUES (?, ?, NOW(), ?)");
            insertBooking.setInt(1, customerId);
            insertBooking.setInt(2, roomId);
            insertBooking.setString(3, "Đã đặt");
            insertBooking.executeUpdate();

            conn.commit();
            System.out.println("Đặt phòng thành công!");

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback(); // rollback khi có lỗi
                    System.out.println("Giao dịch thất bại, rollback!");
                }
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

    private static void logFailedBooking(Connection conn, String customerName, int roomId, String reason) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO failed_bookings (customer_name, room_id, reason) VALUES (?, ?, ?)");
        ps.setString(1, customerName);
        ps.setInt(2, roomId);
        ps.setString(3, reason);
        ps.executeUpdate();
    }

    public static void main(String[] args) {
        bookRoom(1, 101);

        bookRoom(2, 101);

        bookRoom(1000, 1000);
    }
}
