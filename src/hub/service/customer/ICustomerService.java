package hub.service.customer;

import hub.po.customer.Customer;
import hub.po.floor.Floor;
import hub.po.floorDiscuss.FloorDiscuss;
import hub.po.letter.Letter;
import hub.po.topic.Topic;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ICustomerService {
    boolean updatePasswd(Customer customer, String oldpasswd);   //修改密码

    void updateBasicInfo(Customer customer);    //修改基本资料

    void modifyImg(File file, String fileName) throws IOException;  //修改头像

    void setFriend(Customer customer, Integer friendId);        //关注/取关好友

    void setFavorModel(Customer customer, Integer modelId);     //关注/取关模块

    void setFavorTopic(Customer customer, Integer topicId);      //关注/取关话题

    void addTopic(Integer cid, Integer mid, Topic topic);              //发布话题

    void delTopic(Customer customer, Integer topicId);          //删除话题

    void editLetter(Integer cid);

    void sendLetter(Integer cid, Integer rid, Letter letter);          //发送私信

    void floorReply(Integer cid, Integer tid, Floor floor);               //楼内回复，回复楼主

    //层内回复，回复层主
    void inFloorReply(Integer cid, Integer rid, Integer fid, FloorDiscuss inFloor);

    void praise(Integer fid);                                //赞某一楼

    void step(Integer fid);                                 //踩某一楼
}
