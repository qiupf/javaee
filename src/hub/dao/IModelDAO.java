package hub.dao;

import hub.po.model.Model;

import java.util.List;

public interface IModelDAO {
    Model fingById(int id);
    List findByHql(String hql);
}
