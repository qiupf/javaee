package hub.po.customer;

import hub.po.favorModel.FavorModel;
import hub.po.favorTopic.FavorTopic;
import hub.po.floor.Floor;
import hub.po.floorDiscuss.FloorDiscuss;
import hub.po.friends.Friend;
import hub.po.letter.Letter;
import hub.po.topic.Topic;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Customer {
    private Integer id;
    private String account;
    private String password;
    private String image;
    private String motto;
    private Date banned;
    private Date birthday;

    private Set<Friend> friends;//好友 级联删除好友表
    private Set<FavorModel> favorModels=new TreeSet<>();//关注的模块 级联删除关注模块表
    private Set<FavorTopic> favorTopics=new TreeSet<>();//关注的话题 级联删除关注话题表

    private Set<Topic> topics=new TreeSet<>();//发布过的话题 级联删除发布过的话题
    private Set<Floor> floors=new TreeSet<>();//层发言记录 级联删除floor表
    private Set<FloorDiscuss> floorDiscusses=new TreeSet<>();//层内发言记录 级联删除
    private Set<Letter> send=new TreeSet<>();       //私信发送方
    private Set<Letter> receive=new TreeSet<>();   //私信接收方
    private Set<Friend> follows=new TreeSet<>();//被关注 追随者 若客户注销 级联删除好友表
    /* 保留被关注和被回复 */
    //private Set<FloorDiscuss> floorReplys;//层内被回复

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Date getBanned() {
        return banned;
    }

    public void setBanned(Date banned) {
        this.banned = banned;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public Set<FavorModel> getFavorModels() {
        return favorModels;
    }

    public void setFavorModels(Set<FavorModel> favorModels) {
        this.favorModels = favorModels;
    }

    public Set<FavorTopic> getFavorTopics() {
        return favorTopics;
    }

    public void setFavorTopics(Set<FavorTopic> favorTopics) {
        this.favorTopics = favorTopics;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public Set<FloorDiscuss> getFloorDiscusses() {
        return floorDiscusses;
    }

    public void setFloorDiscusses(Set<FloorDiscuss> floorDiscusses) {
        this.floorDiscusses = floorDiscusses;
    }

    public Set<Letter> getSend() {
        return send;
    }

    public void setSend(Set<Letter> send) {
        this.send = send;
    }

    public Set<Letter> getReceive() {
        return receive;
    }

    public void setReceive(Set<Letter> receive) {
        this.receive = receive;
    }

    public Set<Friend> getFollows() {
        return follows;
    }

    public void setFollows(Set<Friend> follows) {
        this.follows = follows;
    }
}
