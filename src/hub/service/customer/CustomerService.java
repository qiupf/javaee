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
import java.util.*;

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
        session = ActionContext.getContext().getSession();
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
        session.put("customer", customer);
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

    @Override
    public void addTopic(Integer cid, Integer mid, Topic topic) {
        Customer c = getCustomerById(cid);
        Model m = getModelById(mid);
        Set<Topic> topics = c.getTopics();
        topic.setDate(new Date());
        topic.setCustomer(c);
        topic.setModel(m);
        topic.setTop(false);
        topics.add(topic);
        c.setTopics(topics);
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
    public void editLetter(Integer cid) {
        session = ActionContext.getContext().getSession();
        Customer c = getCustomerById(cid);
        session.put("receiver", c);
    }

    @Override
    public void sendLetter(Integer cid, Integer rid, Letter letter) {
        Customer customer = getCustomerById(cid);
        Customer receiver = getCustomerById(rid);
        letter.setDate(new Date());
        letter.setRead(false);
        letter.setSender(customer);
        letter.setReceiver(receiver);
        Set<Letter> letters = customer.getSend();
        letters.add(letter);
        customer.setSend(letters);
    }

    @Override
    public void floorReply(Integer cid, Integer tid, Floor floor) {
        session = ActionContext.getContext().getSession();
        Customer customer = getCustomerById(cid);
        Topic topic = getTopicById(tid);
        floor.setDate(new Date());
        floor.setFloor(topic.getFloors().size() + 1);
        floor.setGood(0);
        floor.setBad(0);
        floor.setTopic(topic);
        floor.setCustomer(customer);
        Set<Floor> floors = topic.getFloors();
        floors.add(floor);
        topic.setFloors(floors);
        session.put("floors", floors);
    }

    @Override
    public void inFloorReply(Integer cid, Integer rid, Integer fid, FloorDiscuss inFloor) {
        session = ActionContext.getContext().getSession();
        Customer customer = getCustomerById(cid);
        Customer replyTo = getCustomerById(rid);
        Floor floor = getFloorById(fid);
        inFloor.setDate(new Date());
        inFloor.setCustomer(customer);
        inFloor.setReply(replyTo);
        inFloor.setFloor(floor);
        Set<FloorDiscuss> inFloors = floor.getFloorDiscusses();
        inFloors.add(inFloor);
        floor.setFloorDiscusses(inFloors);
    }

    @Override
    public void praise(Integer fid) {
        session = ActionContext.getContext().getSession();
        Floor floor = getFloorById(fid);
        //System.out.println(floor.getGood());
        //System.out.println("asdfdsfs");
        floor.setGood(floor.getGood() + 1);
        List<Floor> floors = (List) session.get("floors");
        for (Floor f : floors) {
            if (f.getId().equals(fid))
                f.setGood(f.getGood() + 1);
        }
        session.put("floors", floors);
    }

    @Override
    public void step(Integer fid) {
        session = ActionContext.getContext().getSession();
        Floor floor = getFloorById(fid);
        floor.setBad(floor.getBad() + 1);
        List<Floor> floors = (List) session.get("floors");
        for (Floor f : floors) {
            if (f.getId().equals(fid))
                f.setBad(f.getBad() + 1);
        }
        session.put("floors", floors);
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
