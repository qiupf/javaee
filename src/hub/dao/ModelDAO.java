package hub.dao;

import hub.po.model.Model;

import java.util.List;

public class ModelDAO extends BaseDao implements IModelDAO {

    @Override
    public Model fingById(int id) {
        return getSession().get(Model.class,id);
    }

    @Override
    public List findByHql(String hql) {
        return getSession().createQuery(hql).list();
    }
}
