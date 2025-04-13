package Demo.business.dao;

import Demo.business.model.Preson;

import java.util.List;

public interface AppDao<T> {
    List<T> findAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}
