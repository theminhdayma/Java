package Bai4;

import java.time.LocalDate;
import java.time.Period;

class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void printInfo() {
        System.out.println("Tên: " + name + ", Ngày sinh: " + birthDate + ", Tuổi: " + getAge());
    }
}