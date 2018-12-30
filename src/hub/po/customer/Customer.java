package hub.po.customer;

import java.util.Date;
import java.util.Set;

public class Customer {
    private Integer id;
    private String account;
    private String password;
    private String image;
    private Date banned;
    private Date birthday;

    private Set friends;//好友
    private Set favorModels;//关注的模块
    private Set favorTopics;//关注的话题
    private Set discusses;//发言记录
    private Set topics;//发布过的话题

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

    public Set getFriends() {
        return friends;
    }

    public void setFriends(Set friends) {
        this.friends = friends;
    }

    public Set getFavorModels() {
        return favorModels;
    }

    public void setFavorModels(Set favorModels) {
        this.favorModels = favorModels;
    }

    public Set getFavorTopics() {
        return favorTopics;
    }

    public void setFavorTopics(Set favorTopics) {
        this.favorTopics = favorTopics;
    }

    public Set getDiscusses() {
        return discusses;
    }

    public void setDiscusses(Set discusses) {
        this.discusses = discusses;
    }

    public Set getTopics() {
        return topics;
    }

    public void setTopics(Set topics) {
        this.topics = topics;
    }
}
