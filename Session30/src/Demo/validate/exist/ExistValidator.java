
package Demo.validate.exist;

import Demo.business.model.employee.Employee;
import Demo.presentation.employee.EmployeeUI;

import java.util.Scanner;

public class ExistValidator {
    public static String validateExist(Scanner sc, String value, ExistValue existValue) {
        do {
            boolean isExist = false;
            String type = existValue.getType();
            String inputValue = value;
            switch (type) {
                case "employeeId":
                    Employee employeeId = new Employee();
                    employeeId.setEmployee_id(inputValue);
                    isExist = EmployeeUI.employeeService.existEmployeeId(employeeId);
                    break;
                case "email":
                    Employee employeeEmail = new Employee();
                    employeeEmail.setEmail(inputValue);
                    isExist = EmployeeUI.employeeService.existEmail(employeeEmail);
                    break;
                case "phoneNumber":
                    Employee employeePhone = new Employee();
                    employeePhone.setPhoneNumber(inputValue);
                    isExist = EmployeeUI.employeeService.existPhoneNumber(employeePhone);
                    break;
            }

            if (!isExist) {
                return value;
            }

            System.err.println(existValue.getErrorMessage() + ". Vui lòng nhập lại");
            value = sc.nextLine();
        }while (true);
    }
}
