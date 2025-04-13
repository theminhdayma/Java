package Demo.business.model.employee;

import Demo.validate.SelectDepartment;
import Demo.validate.rule.StringRule;
import Demo.validate.Validator;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee {
    private String employee_id;
    private String employee_name;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private int salaryGrade;
    private double salary;
    private LocalDate dateOfBirth;
    private String address;
    private StatusEmployee status;
    private int department_id;

    public Employee() {}

    public Employee(String employee_id, String employee_name, String email, String phoneNumber, Gender gender,
                    int salaryGrade, double salary, LocalDate dateOfBirth, String address,
                    StatusEmployee status, int department_id) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salaryGrade = salaryGrade;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.status = status;
        this.department_id = department_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getSalaryGrade() {
        return salaryGrade;
    }

    public void setSalaryGrade(int salaryGrade) {
        this.salaryGrade = salaryGrade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusEmployee getStatus() {
        return status;
    }

    public void setStatus(StatusEmployee status) {
        this.status = status;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }


    public void inputData(Scanner sc){
        this.employee_id = Validator.inputEmployeeId(sc);

        this.employee_name = Validator.validateInputString(sc, "Nhâp tên nhân viên: ", new StringRule(15, 150));

        this.email = Validator.validateEmail(sc, "Nhập vào email: ");

        this.phoneNumber = Validator.validatePhone(sc, "Nập vào số điện thoại: ");

        this.gender = Validator.validateEnumInput(sc, "Nhập giới tính: ", Gender.class);

        this.salaryGrade = Validator.validateInputInt(sc, "Nhập bậc lương: ");

        this.salary = Validator.validateInputDouble(sc, "Nhập lương: ");

        this.dateOfBirth = Validator.validateInputLocalDate(sc, "Nhập ngày sinh");

        this.address = Validator.validateInputString(sc, "Nhập địa chỉ", new StringRule(0, 250));

        this.status = Validator.validateEnumInput(sc, "Nhập trạng thái: ", StatusEmployee.class);

        this.department_id = SelectDepartment.selectDepartmentId(sc);
    }

    public void displayData() {
        System.out.printf("Employee ID: %s\n", employee_id);
        System.out.printf("Employee Name: %s\n", employee_name);
        System.out.printf("Email: %s\n", email);
        System.out.printf("Phone Number: %s\n", phoneNumber);
        System.out.printf("Gender: %s\n", gender == Gender.MALE ? "Nam" : gender == Gender.FEMALE ? "Nữ" : "Khác");
        System.out.printf("Level Salary: %d\n", salaryGrade);
        System.out.printf("Salary: %.2f\n", salary);
        System.out.printf("Date of Birth: %s\n", dateOfBirth);
        System.out.printf("Address: %s\n", address);
        System.out.printf("Status: %s\n", status == StatusEmployee.ACTIVE ? "Đang hoạt động" : status == StatusEmployee.INACTIVE ? "Không hoạt động" : status == StatusEmployee.ONLEAVE ? "Nghỉ việc" : "Nghỉ chế độ");
        System.out.printf("Department ID: %d\n", department_id);
    }
}
