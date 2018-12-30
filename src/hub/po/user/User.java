package hub.po.user;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer userID;
    private String account;
    private String password;
    private String name;
    private String image;
    private Boolean banned;
    private Set friends;

    public User() {
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set getFriends() {
        return friends;
    }

    public void setFriends(Set friends) {
        this.friends = friends;
    }
}
