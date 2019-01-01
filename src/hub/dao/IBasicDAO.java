package hub.dao;

import java.util.List;

public interface IBasicDAO<T> {
    void save(T instance);

    void delete(T instance);

    void update(T instance);

    List query(String hql);

    T getObjById(T t,int id);

}
