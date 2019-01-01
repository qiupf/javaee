package hub.po.favorTopic;

import hub.po.customer.Customer;
import hub.po.topic.Topic;

import java.util.Date;

public class FavorTopic {
    private Integer id;
    private Date date;

    /* 多对一 */
    private Customer customer;//喜欢该话题的用户
    private Topic topic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
