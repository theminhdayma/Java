package Demo.business.dao.statistic;

import Demo.business.config.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticDaoImp implements StatisticDao {
    @Override
    public Map<String, Integer> getNumEmployeeOfDepartment() {
        Map<String, Integer> map = new LinkedHashMap<>();
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call num_employees_of_department()");

            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                String departmentName = rs.getString("department_name");
                int employeeCount = rs.getInt("count_employee");

                map.put(departmentName, employeeCount);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return map;
    }

    @Override
    public int getTotalEmployees() {
        int total = 0;
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call total_employees_system()");

            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total_employees");
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return total;
    }

    @Override
    public Map<String, Integer> maxEmployeeOfDepartment() {
        Map<String, Integer> map = new LinkedHashMap<>();
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call max_employee_of_department()");

            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                String departmentName = rs.getString("department_name");
                int employeeCount = rs.getInt("count_employee");

                map.put(departmentName, employeeCount);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return map;
    }

    @Override
    public Map<String, Double> maxSalaryOfDepartment() {
        Map<String, Double> map = new LinkedHashMap<>();
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call max_salary_of_department()");

            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                String departmentName = rs.getString("department_name");
                double employeeCount = rs.getDouble("avg_salary");

                map.put(departmentName, employeeCount);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return map;
    }
}

