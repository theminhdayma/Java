package Demo.business.dao.preson;

import Demo.business.dao.AppDao;
import Demo.business.model.Preson;

public interface LoginDao extends AppDao<Preson> {
    boolean login(String username, String password);
}
