package hub.service.customer;

import com.opensymphony.xwork2.ActionContext;
import hub.dao.IBasicDAO;
import hub.po.customer.Customer;
import hub.po.favorModel.FavorModel;
import hub.po.favorTopic.FavorTopic;
import hub.po.floor.Floor;
import hub.po.floorDiscuss.FloorDiscuss;
import hub.po.friends.Friend;
import hub.po.letter.Letter;
import hub.po.model.Model;
import hub.po.topic.Topic;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerService implements ICustomerService {
    private IBasicDAO basicDAO;
    private Map<String, Object> session;
    private Map params;

    public CustomerService() {
    }

    @Override
    public boolean updatePasswd(Customer customer, String oldpasswd) {
        Customer temp = getCustomerById(customer.getId());
        if (oldpasswd.equals(temp.getPassword())) {
            basicDAO.update(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateBasicInfo(Customer customer) {
        basicDAO.update(customer);
    }

    @Override
    public void modifyImg(File file, String fileName) throws IOException {
        session = ActionContext.getContext().getSession();
        // 文件输入流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            // 设置文件保存的目录
            String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
            // 设置目标文件
            File toFile = new File(uploadPath, fileName);
            // 文件输出流
            os = new FileOutputStream(toFile);
            byte[] buffer = new byte[1024];
            int length = 0;
            // 读取file文件输出到toFile文件中
            while (-1 != (length = is.read(buffer, 0, buffer.length))) {
                os.write(buffer);
            }
            Customer customer = (Customer) session.get("customer");
            customer.setImage(fileName);
            basicDAO.update(customer);
            session.put("customer", customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流和输出流
            is.close();
            os.close();
        }
    }

    @Override
    public void setFriend(Customer customer, Integer friendId) {
        customer = getCustomerById(customer.getId());
        Set<Friend> friends = customer.getFriends();
        //现在已有朋友中找
        boolean flag = false;
        for (Friend myFriend : friends) {
            if (myFriend.getFriends().getId().equals(friendId)) {
                //找到就删去
                friends.remove(myFriend);
                flag = true;
                break;
            }
        }
        //找不到就添加
        if (!flag) {
            Customer friend = getCustomerById(friendId);
            Friend newFriend = new Friend();
            newFriend.setCustomer(customer);
            newFriend.setFriends(friend);
            newFriend.setDate(new Date());
            friends.add(newFriend);
        }
        customer.setFriends(friends);
    }

    @Override
    public void setFavorModel(Customer customer, Integer modelId) {
        customer = getCustomerById(customer.getId());
        Set<FavorModel> favorModels = customer.getFavorModels();
        boolean flag = false;
        for (FavorModel favorModel : favorModels) {
            if (favorModel.getModel().getId().equals(modelId)) {
                favorModels.remove(favorModel);
                flag = true;
                break;
            }
        }
        if (!flag) {
            Model model = getModelById(modelId);
            FavorModel newFavorModel = new FavorModel();
            newFavorModel.setCustomer(customer);
            newFavorModel.setModel(model);
            newFavorModel.setDate(new Date());
            favorModels.add(newFavorModel);
        }
        customer.setFavorModels(favorModels);
    }

    @Override
    public void setFavorTopic(Customer customer, Integer topicId) {
        customer = getCustomerById(customer.getId());
        Set<FavorTopic> favorTopics = customer.getFavorTopics();
        boolean flag = false;
        for (FavorTopic favorTopic : favorTopics) {
            if (favorTopic.getId().equals(topicId)) {
                favorTopics.remove(favorTopic);
                flag = true;
                break;
            }
        }
        if (!flag) {
            Topic topic = getTopicById(topicId);
            FavorTopic newFavorTopic = new FavorTopic();
            newFavorTopic.setCustomer(customer);
            newFavorTopic.setTopic(topic);
            newFavorTopic.setDate(new Date());
            favorTopics.add(newFavorTopic);
        }
        customer.setFavorTopics(favorTopics);
    }

    public void addTopic(Customer customer, Topic topic) {
        customer = getCustomerById(customer.getId());
        Model model = getModelById(topic.getModel().getId());
        Set<Topic> topics = customer.getTopics();
        topic.setDate(new Date());
        topic.setCustomer(customer);
        topic.setModel(model);
        topic.setTop(false);
        topics.add(topic);
        customer.setTopics(topics);
    }

    @Override
    public void delTopic(Customer customer, Integer topicId) {
        customer = getCustomerById(customer.getId());
        Set<Topic> topics = customer.getTopics();
        for (Topic topic : topics) {
            if (topic.getId().equals(topicId)) {
                topics.remove(topic);
                break;
            }
        }
        customer.setTopics(topics);
    }

    @Override
    public void sendLetter(Customer customer, Integer sendId, Letter letter) {
        customer = getCustomerById(customer.getId());
        Customer receiver = getCustomerById(sendId);
        letter.setDate(new Date());
        letter.setRead(false);
        letter.setSender(customer);
        letter.setReceiver(receiver);
        Set<Letter> letters = customer.getSend();
        letters.add(letter);
        customer.setSend(letters);
    }

    @Override
    public void floorReply(Customer customer, Integer tid, Floor floor) {
        customer = getCustomerById(customer.getId());
        Topic topic = getTopicById(tid);
        floor.setDate(new Date());
        floor.setGood(0);
        floor.setBad(0);
        floor.setTopic(topic);
        floor.setCustomer(customer);
        Set<Floor> floors = customer.getFloors();
        floors.add(floor);
        customer.setFloors(floors);
    }

    @Override
    public void inFloorReply(Customer customer, Integer rid, Integer fid, FloorDiscuss inFloor) {
        customer = getCustomerById(customer.getId());
        Customer replyTo = getCustomerById(rid);
        Floor floor = getFloorById(fid);
        inFloor.setDate(new Date());
        inFloor.setCustomer(customer);
        inFloor.setReply(replyTo);
        inFloor.setFloor(floor);
        Set<FloorDiscuss> inFloors = customer.getFloorDiscusses();
        inFloors.add(inFloor);
        customer.setFloorDiscusses(inFloors);
    }

    @Override
    public void praise(Integer fid) {
        Floor floor = getFloorById(fid);
        floor.setGood(floor.getGood() + 1);
    }

    @Override
    public void step(Integer fid) {
        Floor floor = getFloorById(fid);
        floor.setBad(floor.getBad() + 1);
    }

    public IBasicDAO getBasicDAO() {
        return basicDAO;
    }

    public void setBasicDAO(IBasicDAO basicDAO) {
        this.basicDAO = basicDAO;
    }

    private Customer getCustomerById(Integer id) {
        String hql = "from Customer where id=" + id;
        return (Customer) basicDAO.query(hql).get(0);
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
