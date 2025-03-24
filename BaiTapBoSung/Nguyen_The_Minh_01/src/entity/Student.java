package entity;

import validate.Validator;

import java.util.Scanner;

public class Student implements IApp{
    private String studentId;
    private String studentName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status = 1;

    public Student(String birthday, String className, String email, float gpa, String major, String phoneNumber, boolean sex, byte status, String studentId, String studentName) {
        this.birthday = birthday;
        this.className = className;
        this.email = email;
        this.gpa = gpa;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.status = status;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Student() {
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }





    @Override
    public void inputData(Scanner scanner) {
        this.studentId = Validator.StudentValidate(scanner, "Nhập mã sinh viên :", "SV\\d{5}");
        this.studentName = Validator.isString(scanner, "Nhập tên sinh viên: ");
        this.birthday = Validator.StudentValidate2(scanner, "Nhập ngày sinh (dd/MM/yyyy):", "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}");
        this.phoneNumber = Validator.StudentValidate2(scanner, "Nhập số điện thoại (10 số, bắt đầu bằng 0):", "0\\d{9}");
        this.email = Validator.StudentValidate2(scanner, "Nhập email (định dạng @gmail.com):", "^[a-zA-Z0-9._%+-]+@gmail\\.com$");
        this.major = Validator.isString(scanner, "Nhập ngành học: ");
        this.className = Validator.isString(scanner, "Nhập tên lớp: ");
        this.gpa = Validator.isFloat(scanner, "Nhập điểm GPA (>= 0): ", 0);
        this.sex = Validator.isBoolean(scanner, "Nhập giới tính (male / female): ");

    }

    @Override
    public void displayData() {
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Tên sinh viên: " + studentName);
        System.out.println("Ngày sinh: " + birthday);
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Ngành học: " + major);
        System.out.println("Tên lớp: " + className);
        System.out.println("Điểm GPA: " + gpa);
        System.out.println("Giới tính: " + (sex? "Nam" : "Nữ"));
        System.out.println("Trạng thái: " +(status == 1 ? "Đang theo học" : (status == 2 ? "Bảo lưu" : "Đang nghỉ học") ));
        System.out.println();

    }
}
