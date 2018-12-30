package hub.dao;

import hub.po.customer.Customer;

import java.util.List;

public class CustomerDAO extends BaseDao
        implements ICustomerDAO {
    @Override
    public void save(Customer customer) {
        getSession().save(customer);
    }

    @Override
    public void delete(Customer customer) {
        getSession().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        getSession().update(customer);
    }

    @Override
    public List query(String hql) {
        return getSession().createQuery(hql).list();
    }

    @Override
    public Customer findById(int id) {
        return getSession().get(Customer.class,id);
    }
}
