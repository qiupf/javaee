package hub.po.floorDiscuss;

import hub.po.customer.Customer;
import hub.po.floor.Floor;

import java.util.Date;

public class FloorDiscuss {
    private Integer id;
    private String detail;
    private Date date;

    /* 多对一 */
    private Customer customer;//回复者
    private Customer reply;//被回复的人
    private Floor floor;   //回复的楼层

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
