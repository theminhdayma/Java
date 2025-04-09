import java.sql.*;

public class Bai1 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/session28";
        String dbUser = "theminhdayma";
        String dbPassword = "123456";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Kết nối thành công!");

            boolean isAutoCommit = connection.getAutoCommit();
            System.out.println("Trạng thái auto-commit ban đầu: " + isAutoCommit);

            connection.setAutoCommit(false);
            System.out.println("Auto-commit đã bị tắt.");

            String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setInt(1, 2);
            statement.setString(2, "Nguyễn Thế Minh");
            statement.setString(3, "theminh2005z@gmail.com");

            int rowsInserted = statement.executeUpdate();
            System.out.println("Số dòng được thêm: " + rowsInserted);

            connection.commit();
            System.out.println("Dữ liệu đã được commit.");

            String selectSQL = "SELECT * FROM users WHERE id = 2";
            ResultSet resultSet = connection.createStatement().executeQuery(selectSQL);

            if (resultSet.next()) {
                System.out.println("Dữ liệu đã được thêm:");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Tên: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            } else {
                System.out.println("Không tìm thấy dữ liệu.");
            }

            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Đã đóng kết nối.");

        } catch (SQLException e) {
            System.out.println("Lỗi SQL:");
            e.printStackTrace();

            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Đã rollback do lỗi.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    }
}
