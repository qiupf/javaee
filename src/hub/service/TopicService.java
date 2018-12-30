package hub.service;

import hub.dao.ITopicDAO;
import hub.po.topic.Topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TopicService implements ITopicService {
    private ITopicDAO topicDAO;

    public ITopicDAO getTopicDAO() {
        return topicDAO;
    }

    public void setTopicDAO(ITopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public List getDisscuss(int topicId) {
        Topic topic=topicDAO.findbyId(topicId);
        Set temp=topic.getDiscusses();
        List discusses=new ArrayList(temp);
        Collections.sort(discusses);
        return discusses;
    }
}
