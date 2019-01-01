package hub.service.visitor;

import hub.dao.IBasicDAO;
import hub.po.floor.Floor;
import hub.po.model.Model;
import hub.po.topic.Topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class VisitorService implements IVisitorService{
    private IBasicDAO basicDAO;

    @Override
    public List getModels() {
        String hql="from Model";
        List models=basicDAO.query(hql);
        Collections.sort(models);
        return models;
    }

    @Override
    public List getTopics(Integer mid) {
        Model model = getModelById(mid);
        Set temp = model.getTopics();
        List topics = new ArrayList(temp);
        Collections.sort(topics);
        return topics;
    }

    @Override
    public List getFloors(Integer tid) {
        Topic topic=getTopicById(tid);
        Set temp=topic.getFloors();
        List floors=new ArrayList(temp);
        Collections.sort(floors);
        return floors;
    }

    public IBasicDAO getBasicDAO() {
        return basicDAO;
    }

    public void setBasicDAO(IBasicDAO basicDAO) {
        this.basicDAO = basicDAO;
    }
    private Model getModelById(Integer id) {
        String hql = "from Model where id=" + id;
        return (Model) basicDAO.query(hql).get(0);
    }

    private Topic getTopicById(Integer id) {
        String hql = "from Topic where id=" + id;
        return (Topic) basicDAO.query(hql).get(0);
    }

    private Floor getFloorById(Integer id) {
        String hql = "from Floor where id=" + id;
        return (Floor) basicDAO.query(hql).get(0);
    }
}
