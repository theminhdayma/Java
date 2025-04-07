package entity;

import util.StringRule;
import util.Validator;

import java.util.Scanner;

public class Course implements IApp{

    String courseId;
    String courseName;
    boolean status;

    public Course(String courseId, String courseName, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        courseId = Validator.validateID("Nhập mã khóa học (Cxxxx) : ", scanner, "course");
        courseName = Validator.validateString("Nhập tên khóa học: ", scanner, new StringRule(20, 100));
        status = Validator.validateBoolean("Nhập trạng thái: ", scanner);
    }

    public void display() {
        System.out.println("Mã KH: " + courseId + ", Tên: " + courseName + ", Trạng thái: " + status);
    }
}
