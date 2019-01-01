package hub.action;

import hub.po.customer.Customer;
import hub.service.customer.ICustomerService;

public class TestAction {
    private ICustomerService customerService;
    private Customer c;

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public String test(){

        return "success";
    }
}
