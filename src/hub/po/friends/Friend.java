package hub.po.friends;

import hub.po.customer.Customer;

import java.util.Date;

public class Friend {
    private Integer id;
    private Date date;

    /* 多对一 */
    private Customer customer;
    private Customer friends;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Customer getFriends() {
        return friends;
    }

    public void setFriends(Customer friends) {
        this.friends = friends;
    }
}
