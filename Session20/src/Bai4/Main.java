package Bai4;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> person = List.of(
                new Person("Quý", LocalDate.of(2000, 3, 25)),
                new Person("Lan", LocalDate.of(1998, 7, 10)),
                new Person("Minh", LocalDate.of(2005, 12, 1))
        );

        person.forEach(Person::printInfo);
    }
}
