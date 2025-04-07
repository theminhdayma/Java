
package business.service.Student;

import business.model.Student;
import business.service.AppService;

public interface StudentService extends AppService<Student> {
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}
