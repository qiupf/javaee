package hub.po.letter;

import hub.po.customer.Customer;

import java.util.Date;

public class Letter {
    private Integer lid;
    private Date date;
    private String theme;
    private String detail;
    private Boolean read;

    private Customer sender;
    private Customer receiver;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getRead() {
        return read;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }
}
