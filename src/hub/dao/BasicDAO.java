package hub.dao;

import java.util.List;

public class BasicDAO<T> extends BaseDao implements IBasicDAO<T>{
    @Override
    public void save(T instance) {
        getSession().save(instance);
    }

    @Override
    public void delete(T instance) {
        getSession().delete(instance);
    }

    @Override
    public void update(T instance) {
        getSession().update(instance);
    }

    @Override
    public List query(String hql) {
        return getSession().createQuery(hql).list();
    }

    @Override
    public T getObjById(T t, int id) {
        return (T) getSession().get(t.getClass(),id);
    }
}
