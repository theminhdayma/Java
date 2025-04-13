package Demo.business.dao.employee;

import Demo.business.config.ConnectionDB;
import Demo.business.model.employee.Employee;
import Demo.business.model.employee.Gender;
import Demo.business.model.employee.StatusEmployee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {

    @Override
    public boolean existEmployeeId(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_exist_employee_id(?)}");

            callSt.setString(1, employee.getEmployee_id());

            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("is_exist_emp_id");
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

    @Override
    public boolean existEmail(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_exist_email(?)}");

            callSt.setString(1, employee.getEmail());

            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("is_exist_email");
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

    @Override
    public boolean existPhoneNumber(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_exist_phone_number(?)}");

            callSt.setString(1, employee.getPhoneNumber());

            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("is_exist_phone");
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

    @Override
    public List<Employee> paginateEmployee(int currentPage) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call get_pagination_employees(?)");

            callSt.setInt(1, currentPage);

            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getString("employee_id"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setGender(Gender.valueOf(rs.getString("gender")));
                employee.setSalaryGrade(rs.getInt("level_salary"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                employee.setAddress(rs.getString("address"));
                    employee.setStatus(StatusEmployee.valueOf(rs.getString("status")));
                employee.setDepartment_id(rs.getInt("department_id"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public Employee findEmployeeById(String employeeId) {
        return null;
    }

    @Override
    public List<Employee> searchEmployee(String employeeName, LocalDate dateFrom, LocalDate dateTo) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call search_employee(?,?,?)");

            callSt.setString(1, employeeName);
            callSt.setString(2, dateFrom.toString());
            callSt.setString(3, dateTo.toString());

            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getString("employee_id"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setGender(Gender.valueOf(rs.getString("gender")));
                employee.setSalaryGrade(rs.getInt("level_salary"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                employee.setAddress(rs.getString("address"));
                employee.setStatus(StatusEmployee.valueOf(rs.getString("status")));
                employee.setDepartment_id(rs.getInt("department_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public List<Employee> sortEmployeeBySalary() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call sort_employee_by_salary()");

            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getString("employee_id"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setGender(Gender.valueOf(rs.getString("gender")));
                employee.setSalaryGrade(rs.getInt("level_salary"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                employee.setAddress(rs.getString("address"));
                employee.setStatus(StatusEmployee.valueOf(rs.getString("status")));
                employee.setDepartment_id(rs.getInt("department_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public List<Employee> sortEmployeeByName() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call sort_employee_by_name()");

            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getString("employee_id"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setGender(Gender.valueOf(rs.getString("gender")));
                employee.setSalaryGrade(rs.getInt("level_salary"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                employee.setAddress(rs.getString("address"));
                employee.setStatus(StatusEmployee.valueOf(rs.getString("status")));
                employee.setDepartment_id(rs.getInt("department_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call get_all_employees()");

            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getString("employee_id"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setGender(Gender.valueOf(rs.getString("gender")));
                employee.setSalaryGrade(rs.getInt("level_salary"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                employee.setAddress(rs.getString("address"));
                employee.setStatus(StatusEmployee.valueOf(rs.getString("status")));
                employee.setDepartment_id(rs.getInt("department_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public boolean save(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call add_employee(?,?,?,?,?,?,?,?,?,?,?)");

            callSt.setString(1, employee.getEmployee_id());
            callSt.setString(2, employee.getEmployee_name());
            callSt.setString(3, employee.getEmail());
            callSt.setString(4, employee.getPhoneNumber());
            callSt.setString(5, employee.getGender().name());
            callSt.setInt(6, employee.getSalaryGrade());
            callSt.setDouble(7, employee.getSalary());
            callSt.setString(8, employee.getDateOfBirth().toString());
            callSt.setString(9, employee.getAddress());
            callSt.setString(10, employee.getStatus().name());
            callSt.setInt(11, employee.getDepartment_id());

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
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call delete_employee(?)");

            callSt.setString(1, employee.getEmployee_id());

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
}
