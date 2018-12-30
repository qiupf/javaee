package hub.dao;

import hub.po.customer.Customer;

import java.util.List;

public interface ICustomerDAO {
    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    List query(String hql);

    Customer findById(int id);

}
