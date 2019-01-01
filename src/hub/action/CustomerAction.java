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

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CustomerAction extends ActionSupport {
    private ICustomerService customerService;
    private Map params;
    private Customer loginUser=new Customer();
    private Topic topic;
    private Letter letter;
    private Floor floor;
    private FloorDiscuss floorDiscuss;
    private File photo;


    public CustomerAction() {

    }

    //注册
    public String register() {
        if (customerService.register(loginUser)) {
            return "registerSuccess";
        }
        return "registerFail";
    }

    //登录
    public String login() {
        if (customerService.login(loginUser)) {
            return "loginSuccess";
        }
        this.addActionError("用户名或密码错误，请重新输入！");
        return "loginFail";
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
        String fileName=((String[]) params.get("photoFileName"))[0];
        customerService.modifyImg(photo,fileName);
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
        Integer modelId = Integer.valueOf(((String[]) params.get("modelId"))[0]);
        customerService.setFavorModel(loginUser, modelId);
        System.out.println("setFavorModelSuccess");
        return "setFavorModelSuccess";
    }

    //添加话题
    public String addTopic() {
        /*Model model = new Model();
        model.setId(modelId);
        topic = new Topic();
        topic.setModel(model);
        topic.setMode("活动");
        topic.setName("asd");*/
        customerService.addTopic(loginUser, topic);
        System.out.println("addTopicSuccess");
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

    //发私信
    String sendLetter() {
        Integer sendId = Integer.valueOf(((String[]) params.get("sendId"))[0]);
        customerService.sendLetter(loginUser, sendId, letter);
        return "sendLetterSuccess";
    }

    //楼回复
    String floorReply() {
        Integer topicId = Integer.valueOf(((String[]) params.get("topicId"))[0]);
        customerService.floorReply(loginUser, topicId, floor);
        return "floorReplySuccess";
    }

    //层回复
    String inFloorReply() {
        Integer floorId = Integer.valueOf(((String[]) params.get("floorId"))[0]);
        Integer replyId = Integer.valueOf(((String[]) params.get("replyId"))[0]);
        customerService.inFloorReply(loginUser, replyId, floorId, floorDiscuss);
        return "inFloorReplySuccess";
    }

    //赞楼层
    String praise() {
        Integer floorId = Integer.valueOf(((String[]) params.get("floorId"))[0]);
        customerService.praise(floorId);
        return "praiseSuccess";
    }

    //踩楼层
    String step() {
        Integer floorId = Integer.valueOf(((String[]) params.get("floorId"))[0]);
        customerService.step(floorId);
        return "stepSuccess";
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
}
