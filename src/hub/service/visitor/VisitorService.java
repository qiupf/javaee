package hub.service.visitor;

import com.opensymphony.xwork2.ActionContext;
import hub.dao.IBasicDAO;
import hub.po.customer.Customer;
import hub.po.favorModel.FavorModel;
import hub.po.favorTopic.FavorTopic;
import hub.po.floor.Floor;
import hub.po.letter.Letter;
import hub.po.model.Model;
import hub.po.topic.Topic;

import java.util.*;

public class VisitorService implements IVisitorService {
    private IBasicDAO basicDAO;
    private Map<String, Object> session;

    @Override
    public boolean register(Customer customer) {
        basicDAO.save(customer);
        session.put("customerId", customer.getId());
        return true;
    }

    @Override
    public boolean login(Customer customer) {
        session = ActionContext.getContext().getSession();
        String hql = "from Customer where id=" + customer.getId() + " and password='" + customer.getPassword() + "'";
        List list = basicDAO.query(hql);
        if (list.isEmpty()) {
            return false;
        } else {
            customer = (Customer) list.get(0);
            /*for (Topic t : customer.getTopics())
                t.getCustomer();
            for (Floor f : customer.getFloors())
                f.getCustomer();
            for (FavorModel fm : customer.getFavorModels())
                fm.getCustomer();
            for (FavorTopic ft : customer.getFavorTopics())
                ft.getCustomer();
            for (Letter ts : customer.getSend())
                ts.getSender();
            for (Letter tr : customer.getReceive())
                tr.getReceiver();*/
            session.put("customer", customer);
            return true;
        }
    }

    @Override
    public List getModels() {
        String hql = "from Model";
        List models = basicDAO.query(hql);
        Collections.sort(models);
        return models;
    }

    @Override
    public List getTopics(Integer mid) {
        Model model = getModelById(mid);
        Set temp = model.getTopics();
        List<Topic> topics = new ArrayList(temp);
        Collections.sort(topics);
        /*for (Topic t : topics) {
            t.getCustomer().getTopics();
            for (Floor floor : t.getFloors())
                floor.getTopic();
            for (FavorTopic favor : t.getFavorTopics())
                favor.getTopic();
        }*/
        return topics;
    }

    @Override
    public List getFloors(Integer tid) {
        Topic topic = getTopicById(tid);
        Set temp = topic.getFloors();
        List<Floor> floors = new ArrayList(temp);
        topic.getCustomer().getTopics();
        Collections.sort(floors);
       /* for (Topic t : topic.getCustomer().getTopics())
            t.getCustomer();
        for (Floor f : floors) {
            for (Topic t : f.getCustomer().getTopics())
                t.getCustomer();
        }*/
        return floors;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        String hql = "from Customer where id=" + id;
        return (Customer) basicDAO.query(hql).get(0);
    }

    public Model getModelById(Integer id) {
        String hql = "from Model where id=" + id;
        return (Model) basicDAO.query(hql).get(0);
    }

    public Topic getTopicById(Integer id) {
        String hql = "from Topic where id=" + id;
        return (Topic) basicDAO.query(hql).get(0);
    }

    private Floor getFloorById(Integer id) {
        String hql = "from Floor where id=" + id;
        return (Floor) basicDAO.query(hql).get(0);
    }

    public IBasicDAO getBasicDAO() {
        return basicDAO;
    }

    public void setBasicDAO(IBasicDAO basicDAO) {
        this.basicDAO = basicDAO;
    }
}
