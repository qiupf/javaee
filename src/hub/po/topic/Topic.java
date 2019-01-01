package hub.po.topic;

import hub.po.customer.Customer;
import hub.po.floor.Floor;
import hub.po.favorTopic.FavorTopic;
import hub.po.model.Model;

import java.util.Date;
import java.util.Set;

public class Topic implements Comparable<Topic> {
    private Integer id;
    private String mode;
    private String name;
    private Boolean top;
    private Date date;

    /* 多对一 */
    private Model model;//属于哪个模块 mid
    private Customer customer;//属于哪个客户发起 cid

    /* 一对多 */
    private Set<Floor> floors;//层发言记录 级联删除 tid
    private Set<FavorTopic> favorTopics;//被关注 级联删除 tid

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<FavorTopic> getFavorTopics() {
        return favorTopics;
    }

    public void setFavorTopics(Set<FavorTopic> favorTopics) {
        this.favorTopics = favorTopics;
    }

    @Override
    public int compareTo(Topic o) {
        if (this.top) {
            if (o.top) {
                return o.id - this.id; //右边比左边大
            } else {
                return -1;
            }
        } else {
            if (o.top) {
                return 1;
            } else {
                return o.id - this.id;
            }
        }
    }
}
