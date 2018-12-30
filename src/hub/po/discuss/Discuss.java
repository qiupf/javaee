package hub.po.discuss;

import hub.po.customer.Customer;
import hub.po.topic.Topic;

import java.util.Date;

public class Discuss implements Comparable<Discuss>{
    private Integer id;
    private Integer floor;
    private String detail;
    private Date date;
    private Integer good;
    private Integer bad;

    /* customer 回复 reply */
    private Customer customer;//发言者
    private Customer reply;//回复的人
    private Topic topic;//属于哪个话题

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

    public Customer getReply() {
        return reply;
    }

    public void setReply(Customer reply) {
        this.reply = reply;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public int compareTo(Discuss o) {
        return o.id-this.id;
    }
}
