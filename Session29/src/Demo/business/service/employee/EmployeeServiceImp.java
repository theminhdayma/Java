package Demo.business.service.employee;

import Demo.business.dao.employee.EmployeeDao;
import Demo.business.dao.employee.EmployeeDaoImp;
import Demo.business.model.employee.Employee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDao.delete(employee);
    }

    @Override
    public boolean existEmployeeId(Employee employee) {
        return employeeDao.existEmployeeId(employee);
    }

    @Override
    public boolean existEmail(Employee employee) {
        return employeeDao.existEmail(employee);
    }

    @Override
    public boolean existPhoneNumber(Employee employee) {
        return employeeDao.existPhoneNumber(employee);
    }

    @Override
    public List<Employee> paginateEmployee(int currentPage) {
        return employeeDao.paginateEmployee(currentPage);
    }

    @Override
    public Employee findEmployeeById(String employeeId) {
        return employeeDao.findEmployeeById(employeeId);
    }

    @Override
    public List<Employee> searchEmployee(String employeeName, LocalDate dateFrom, LocalDate dateTo) {
        return employeeDao.searchEmployee(employeeName, dateFrom, dateTo);
    }

    @Override
    public List<Employee> sortEmployeeBySalary() {
        return employeeDao.sortEmployeeBySalary();
    }

    @Override
    public List<Employee> sortEmployeeByName() {
        return employeeDao.sortEmployeeByName();
    }
}