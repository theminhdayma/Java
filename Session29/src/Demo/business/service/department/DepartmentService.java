package Demo.business.service.department;

import Demo.business.model.Department;
import Demo.business.service.AppService;

import java.util.List;

public interface DepartmentService extends AppService<Department> {
    List<Department> searchDepartment(String departmentName);

    List<Department> paginateDepartment(int currentPage);

    Department findDepartmentById(int departmentId);

    List<Department> findDepartmentByName(String name);
}
