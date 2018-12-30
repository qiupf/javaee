package hub.service;

import hub.po.customer.Customer;

public interface ICustomerService {
    boolean register(Customer customer);

    boolean login(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    void setFriend(Customer customer, Integer friendId);


}
