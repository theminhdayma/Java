package business.dao.account;

import business.config.ConnectionDB;
import business.model.Account;
import business.model.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImp implements AccountDao{
    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();

            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call funds_transfer_amount(?, ?, ?, ?, ?, ?)}");
            callSt.setInt(1, accSenderId);
            callSt.setString(2, accSenderName);
            callSt.setInt(3, accReceiverId);
            callSt.setString(4, accReceiverName);
            callSt.setDouble(5, amount);

            callSt.registerOutParameter(6, Types.INTEGER);

            callSt.execute();
            conn.commit();

            return callSt.getInt(6);
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public Account findAccountById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Account account = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_account_by_Id(?)}");

            callSt.setInt(1, id);

            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setId(rs.getInt("acc_id"));
                account.setName(rs.getString("acc_name"));
                account.setStatus(Status.valueOf(rs.getString("acc_status")));
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return account;
    }

    @Override
    public double checkBalance(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call check_balance(?)}");

            callSt.setInt(1, account.getId());

            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                account.setBalance(rs.getDouble("acc_balance"));
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return account.getBalance();
    }

    @Override
    public List<Account> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Account> accountList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_accounts()}");

            ResultSet rs = callSt.executeQuery();
            accountList = new ArrayList<>();

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("acc_id"));
                account.setName(rs.getString("acc_name"));
                account.setBalance(rs.getDouble("acc_balance"));
                account.setStatus(Status.valueOf(rs.getString("acc_status")));
                accountList.add(account);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return accountList;
    }

    @Override
    public boolean add(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_account(?, ?, ?)}");

            callSt.setString(1, account.getName());
            callSt.setDouble(2, account.getBalance());
            callSt.setString(3, account.getStatus().toString());

            callSt.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_account(?, ?, ?)}");

            callSt.setInt(1, account.getId());
            callSt.setString(2, account.getName());
            callSt.setString(3, account.getStatus().toString());

            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(Account account) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_account(?)}");

            callSt.setInt(1, account.getId());

            int rs = callSt.executeUpdate();

            if (rs == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
