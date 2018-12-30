package hub.dao;

import hub.po.topic.Topic;

import java.util.List;

public interface ITopicDAO {
    Topic findbyId(int id);
    List findByHql(String hql);
}
