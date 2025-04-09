package business.dao.fundTransfer;

import business.config.ConnectionDB;
import business.model.FundTransfer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FundTrsDaoImp implements FundTrsDao{
    @Override
    public List<FundTransfer> getAllFundTransfers() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<FundTransfer> fundTransferList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_fundTrfs()}");

            ResultSet rs = callSt.executeQuery();
            fundTransferList = new ArrayList<>();

            while (rs.next()) {
                FundTransfer fundTransfer = new FundTransfer();
                fundTransfer.setFdId(rs.getInt("fd_id"));
                fundTransfer.setAccSenderId(rs.getInt("acc_sender_id"));
                fundTransfer.setAccReceiverId(rs.getInt("acc_receiver_id"));
                fundTransfer.setAmount(rs.getDouble("fd_amount"));
                fundTransfer.setFdCreated(rs.getDate("fd_created").toLocalDate());
                fundTransfer.setStatus(rs.getByte("fd_status"));
                fundTransferList.add(fundTransfer);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return fundTransferList;
    }

    @Override
    public double totalMoney(LocalDate from, LocalDate to) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_money(?, ?, ?)}");

            callSt.setDate(1, Date.valueOf(from));
            callSt.setDate(2, Date.valueOf(to));

            callSt.registerOutParameter(3, Types.DOUBLE);

            callSt.execute();

            return callSt.getDouble(3);
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public double getTotalMoneyByAccount(int accReceiverId) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_totalMoney_by_account(?, ?)}");

            callSt.setInt(1, accReceiverId);

            callSt.registerOutParameter(2, Types.DOUBLE);

            callSt.execute();

            return callSt.getDouble(2);
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }

    @Override
    public int countSuccessedFundTransfer(LocalDate from, LocalDate to) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call count_sucessed_status(?, ?, ?)}");

            callSt.setDate(1, Date.valueOf(from));
            callSt.setDate(2, Date.valueOf(to));
            callSt.registerOutParameter(3, Types.INTEGER);

            callSt.execute();

            return callSt.getInt(3);
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }
}
