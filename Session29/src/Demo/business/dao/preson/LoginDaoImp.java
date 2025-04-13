package Demo.business.dao.preson;

import Demo.business.config.ConnectionDB;
import Demo.business.model.Preson;

import java.sql.*;
import java.util.List;

public class LoginDaoImp implements LoginDao {

    @Override
    public List<Preson> findAll() {
        return List.of();
    }

    @Override
    public boolean save(Preson preson) {
        return false;
    }

    @Override
    public boolean update(Preson preson) {
        return false;
    }

    @Override
    public boolean delete(Preson preson) {
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();

            callSt = conn.prepareCall("{call login(?, ?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);

            ResultSet rs = callSt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return false;
    }

}
