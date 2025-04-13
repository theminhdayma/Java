package Demo.business.dao.department;

import Demo.business.config.ConnectionDB;
import Demo.business.model.Department;
import Demo.business.model.Preson;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImp implements DepartmentDao {
    @Override
    public List<Department> searchDepartment(String departmentName) {
        List<Department> departments = null;
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call search_department(?)}");
            cs.setString(1, departmentName);
            ResultSet rs = cs.executeQuery();

            departments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartment_id(rs.getInt("DepartmentId"));
                department.setDepartment_name(rs.getString("DepartmentName"));
                department.setDepartment_description(rs.getString("DepartmentDescription"));
                department.setDepartment_status(rs.getBoolean("DepartmentStatus"));

                departments.add(department);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi khi kết nối tới CSDL");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với DB: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return departments;
    }

    @Override
    public List<Department> paginateDepartment(int currentPage) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departmentList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("call get_pagination_department(?)");

            callSt.setInt(1, currentPage);

            ResultSet rs = callSt.executeQuery();
            departmentList = new ArrayList<>();

            while (rs.next()) {
                Department department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_name(rs.getString("department_name"));
                department.setDepartment_description(rs.getString("description"));
                department.setDepartment_status(rs.getBoolean("status"));
                departmentList.add(department);
            }

        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departmentList;
    }

    @Override
    public Department findDepartmentById(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Department department = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_department_by_id(?)}");

            callSt.setInt(1, departmentId);

            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_name(rs.getString("department_name"));
                department.setDepartment_description(rs.getString("description"));
                department.setDepartment_status(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return department;
    }

    @Override
    public List<Department> findDepartmentByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departmentList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_department_by_name(?)}");

            callSt.setString(1, name);

            ResultSet rs = callSt.executeQuery();
            departmentList = new ArrayList<>();

            if (rs.next()) {
                Department department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_name(rs.getString("department_name"));
                department.setDepartment_description(rs.getString("description"));
                department.setDepartment_status(rs.getBoolean("status"));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departmentList;
    }


    @Override
    public List<Department> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departmentList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_department()}");

            ResultSet rs = callSt.executeQuery();
            departmentList = new ArrayList<>();

            while (rs.next()) {
                Department department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_name(rs.getString("department_name"));
                department.setDepartment_description(rs.getString("description"));
                department.setDepartment_status(rs.getBoolean("status"));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            System.err.println("Có lỗi xử lý SQL " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return departmentList;
    }

    @Override
    public boolean save(Department department) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call create_department(?,?,?)}");
            cs.setString(1, department.getDepartment_name());
            cs.setString(2, department.getDepartment_description());
            cs.setBoolean(3, department.isDepartment_status());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Có lỗi khi kết nối tới CSDL");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với DB: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean update(Department department) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call update_department(?,?,?,?)}");
            cs.setInt(1, department.getDepartment_id());
            cs.setString(2, department.getDepartment_name());
            cs.setString(3, department.getDepartment_description());
            cs.setBoolean(4, department.isDepartment_status());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Có lỗi khi kết nối tới CSDL");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với DB: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean delete(Department department) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call delete_department(?)}");
            cs.setInt(1, department.getDepartment_id());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Có lỗi khi kết nối tới CSDL");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với DB: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }
}
