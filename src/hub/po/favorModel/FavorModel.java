package hub.po.favorModel;

import hub.po.customer.Customer;
import hub.po.model.Model;

import java.util.Date;

public class FavorModel {
    private Integer id;
    private Date date;

    /* 多对一 */
    private Customer customer;//喜欢该模块的用户
    private Model model;//该模块


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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
