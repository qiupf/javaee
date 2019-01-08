package hub.po.floor;

import hub.po.customer.Customer;
import hub.po.floorDiscuss.FloorDiscuss;
import hub.po.topic.Topic;

import java.util.Date;
import java.util.Set;

public class Floor implements Comparable<Floor> {
    private Integer id;
    private Integer floor;
    private String detail;
    private Date date;
    private Integer good;
    private Integer bad;

    /* 多对一 */
    private Customer customer;//发言者
    private Topic topic;//属于哪个话题

    /* 多对一 */
    private Set<FloorDiscuss> floorDiscusses;//层发言 级联删除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getBad() {
        return bad;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<FloorDiscuss> getFloorDiscusses() {
        return floorDiscusses;
    }

    public void setFloorDiscusses(Set<FloorDiscuss> floorDiscusses) {
        this.floorDiscusses = floorDiscusses;
    }

    @Override
    public int compareTo(Floor o) {
        return this.floor - o.floor;
    }
}
