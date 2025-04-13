package Demo.business.service.employee;

import Demo.business.model.employee.Employee;
import Demo.business.service.AppService;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService extends AppService<Employee> {
    boolean existEmployeeId(Employee employee);
    boolean existEmail(Employee employee);
    boolean existPhoneNumber(Employee employee);

    List<Employee> paginateEmployee(int currentPage);

    Employee findEmployeeById(String employeeId);

    List<Employee> searchEmployee(String employeeName, LocalDate dateFrom, LocalDate dateTo);

    List<Employee> sortEmployeeBySalary();

    List<Employee> sortEmployeeByName();
}
