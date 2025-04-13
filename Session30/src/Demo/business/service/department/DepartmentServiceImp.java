package Demo.business.service.department;

import Demo.business.dao.department.DepartmentDao;
import Demo.business.dao.department.DepartmentDaoImp;
import Demo.business.model.Department;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentDao departmentDao;
    public DepartmentServiceImp() {
        departmentDao = new DepartmentDaoImp();
    }

    @Override
    public List<Department> searchDepartment(String departmentName) {
        return departmentDao.searchDepartment(departmentName);
    }

    @Override
    public List<Department> paginateDepartment(int currentPage) {
        return departmentDao.paginateDepartment(currentPage);
    }

    @Override
    public Department findDepartmentById(int departmentId) {
        return departmentDao.findDepartmentById(departmentId);
    }

    @Override
    public List<Department> findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public boolean save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentDao.update(department);
    }

    @Override
    public boolean delete(Department department) {
        return departmentDao.delete(department);
    }
}
