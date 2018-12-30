package hub.po.topic;

import hub.po.customer.Customer;
import hub.po.discuss.Discuss;
import hub.po.model.Model;

import java.util.Date;
import java.util.Set;

public class Topic implements Comparable<Topic>{
    private Integer id;
    private String mode;
    private String name;
    private Boolean top;
    private Date date;

    private Model model;
    private Customer customer;
    private Set<Discuss> discusses;//发言记录

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

    public Set<Discuss> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(Set<Discuss> discusses) {
        this.discusses = discusses;
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

    @Override
    public int compareTo(Topic o) {
        if(this.top){
            if(o.top)
                return o.id-this.id;
            else
                return -1;
        }
        else {
            if(o.top)
                return 1;
            else
                return o.id-this.id;
        }
    }
}
