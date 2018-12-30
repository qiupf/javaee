package hub.dao;

import hub.po.topic.Topic;

import java.util.List;

public class TopicDAO extends BaseDao implements ITopicDAO {

    @Override
    public Topic findbyId(int id) {
        return getSession().get(Topic.class, id);
    }

    @Override
    public List findByHql(String hql) {
        return getSession().createQuery(hql).list();
    }
}
