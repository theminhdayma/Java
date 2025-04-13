package Demo.business.dao.department;

import Demo.business.dao.AppDao;
import Demo.business.model.Department;

import java.util.List;

public interface DepartmentDao extends AppDao<Department> {
    List<Department> searchDepartment(String departmentName);

    List<Department> paginateDepartment(int currentPage);

    Department findDepartmentById(int departmentId);

    List<Department> findDepartmentByName(String name);
}
