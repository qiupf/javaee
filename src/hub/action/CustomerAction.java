package hub.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hub.po.customer.Customer;
import hub.po.floor.Floor;
import hub.po.floorDiscuss.FloorDiscuss;
import hub.po.letter.Letter;
import hub.po.model.Model;
import hub.po.topic.Topic;
import hub.service.customer.ICustomerService;
import hub.service.visitor.IVisitorService;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomerAction extends ActionSupport {
    private ICustomerService customerService;
    private IVisitorService visitorService;
    private Map params;
    private Map session;
    private Customer loginUser = new Customer();
    private Model model;
    private Topic topic = new Topic();
    private Letter letter = new Letter();
    private Floor floor = new Floor();
    private FloorDiscuss floorDiscuss = new FloorDiscuss();
    private File photo;


    public CustomerAction() {

    }

    //修改密码
    public String updatePasswd() {
        //获取从请求传过来的原密码
        String oldpasswd = ((String[]) params.get("oldpasswd"))[0];
        if (customerService.updatePasswd(loginUser, oldpasswd))
            return "updatePasswdSuccess";
        else
            return "updatePasswdFail";
    }

    //修改基本信息
    public String updateBasicInfo() {
        customerService.updateBasicInfo(loginUser);
        return "updateBasicSuccess";
    }

    //修改头像
    public String modifyImg() throws IOException {
        params = ActionContext.getContext().getParameters();
        try {
            String fileName = ((String[]) params.get("photoFileName"))[0];
            customerService.modifyImg(photo, fileName);
        } catch (Exception e) {
            return "modifyImgFail";
        }
        return "modifyImgSuccess";
    }

    //关注或不关注好友
    public String setFriend() {
        //获取从请求传过来的好友ID
        Integer friendId = Integer.valueOf(((String[]) params.get("friendId"))[0]);
        customerService.setFriend(loginUser, friendId);
        System.out.println("setFriendSuccess");
        return "setFriendSuccess";
    }

    //关注或不关注模块
    public String setFavorModel() {
        //获取从请求传过来的模块ID
        params = ActionContext.getContext().getParameters();
        session = ActionContext.getContext().getSession();
        Integer modelId = Integer.valueOf(((String[]) params.get("modelId"))[0]);
        loginUser = (Customer) session.get("customer");
        customerService.setFavorModel(loginUser, modelId);
        System.out.println("setFavorModelSuccess");
        return "setFavorModelSuccess";
    }

    //添加话题
    public String addTopic() {
        session = ActionContext.getContext().getSession();
        Model model = (Model) session.get("model");
        Integer cid = ((Customer) session.get("customer")).getId();
        Integer mid = ((Model) session.get("model")).getId();
        customerService.addTopic(cid, mid, topic);
        List topics = visitorService.getTopics(Integer.valueOf(model.getId()));
        Customer c = (Customer) session.get("customer");
        Customer customer = visitorService.getCustomerById(c.getId());
        session.put("customer", customer);
        session.put("topics", topics);
        //System.out.println("addTopicSuccess");
        return "addTopicSuccess";
    }

    //删除话题
    public String delTopic() {
        topic = new Topic();
        topic.setId(1);
        customerService.delTopic(loginUser, topic.getId());
        System.out.println("delTopicSuccess");
        return "delTopicSuccess";
    }

    public String editLetter() {
        params = ActionContext.getContext().getParameters();
        Integer cid = Integer.valueOf(((String[]) params.get("rid"))[0]);
        customerService.editLetter(cid);
        return "editLetterSuccess";
    }

    //发私信
    public String sendLetter() {
        params = ActionContext.getContext().getParameters();
        session = ActionContext.getContext().getSession();
        Integer cid = ((Customer) session.get("customer")).getId();
        Integer rid = ((Customer) session.get("receiver")).getId();
        customerService.sendLetter(cid, rid, letter);
        return "sendLetterSuccess";
    }

    //楼回复
    public String floorReply() {
        session = ActionContext.getContext().getSession();
        Customer c = (Customer) session.get("customer");
        Topic t = (Topic) session.get("topic");
        Integer cid = c.getId();
        Integer tid = t.getId();
        customerService.floorReply(cid, tid, floor);
        return "floorReplySuccess";
    }

    //层回复
    public String inFloorReply() {
        session = ActionContext.getContext().getSession();
        params = ActionContext.getContext().getParameters();
        Topic topic = (Topic) session.get("topic");
        Integer cid = ((Customer) session.get("customer")).getId();
        Integer fid = Integer.valueOf(((String[]) params.get("fid"))[0]);
        Integer rid = Integer.valueOf(((String[]) params.get("rid"))[0]);
        customerService.inFloorReply(cid, rid, fid, floorDiscuss);
        List floors = visitorService.getFloors(Integer.valueOf(topic.getId()));
        session.put("floors", floors);
        return "inFloorReplySuccess";
    }

    //赞楼层
    public String praise() {
        params = ActionContext.getContext().getParameters();
        String floorId = ((String[]) params.get("floorId"))[0];
        customerService.praise(Integer.valueOf(floorId));
        return "praiseSuccess";
    }

    //踩楼层
    public String step() {
        params = ActionContext.getContext().getParameters();
        Integer floorId = Integer.valueOf(((String[]) params.get("floorId"))[0]);
        customerService.step(floorId);
        return "stepSuccess";
    }

    public String logout() {
        session = ActionContext.getContext().getSession();
        session.put("customer", null);
        return "logoutSuccess";
    }

    public String missMessage() {
        session = ActionContext.getContext().getSession();
        Customer c = (Customer) session.get("customer");
        Customer customer = visitorService.getCustomerById(c.getId());
        session.put("customer", customer);
        return "missMessageSuccess";
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Customer loginUser) {
        this.loginUser = loginUser;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public FloorDiscuss getFloorDiscuss() {
        return floorDiscuss;
    }

    public void setFloorDiscuss(FloorDiscuss floorDiscuss) {
        this.floorDiscuss = floorDiscuss;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public IVisitorService getVisitorService() {
        return visitorService;
    }

    public void setVisitorService(IVisitorService visitorService) {
        this.visitorService = visitorService;
    }
}
