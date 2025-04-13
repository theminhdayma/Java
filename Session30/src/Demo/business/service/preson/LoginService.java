package Demo.business.service.preson;

import Demo.business.model.Preson;
import Demo.business.service.AppService;

public interface LoginService extends AppService<Preson> {
    boolean login(String username, String password);
}
