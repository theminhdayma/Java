
package business.service.classroom;

import business.model.ClassRoom;
import business.service.AppService;

public interface ClassroomService extends AppService<ClassRoom> {
    ClassRoom findById(int id);
}
