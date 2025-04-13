package Demo.business.service.preson;

import Demo.business.dao.preson.LoginDao;
import Demo.business.dao.preson.LoginDaoImp;
import Demo.business.model.Preson;

import java.util.List;

public class LoginServiceImp implements LoginService {
    private final LoginDao loginDao;

    public LoginServiceImp() {
        loginDao = new LoginDaoImp();
    }

    @Override
    public boolean login(String username, String password) {
        return loginDao.login(username, password);
    }

    @Override
    public List<Preson> findAll() {
        return List.of();
    }

    @Override
    public boolean save(Preson preson) {
        return false;
    }

    @Override
    public boolean update(Preson preson) {
        return false;
    }

    @Override
    public boolean delete(Preson preson) {
        return false;
    }
}
