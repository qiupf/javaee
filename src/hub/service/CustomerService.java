package hub.service;


import hub.dao.ICustomerDAO;
import hub.po.customer.Customer;
import hub.po.discuss.Discuss;
import hub.po.friends.Friend;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerService implements ICustomerService {
    private ICustomerDAO customerDAO;
    private Map<String, Object> session;

    @Override
    public boolean register(Customer customer) {
        String hql = "from Customer where id=" + customer.getId();
        if (!customerDAO.query(hql).isEmpty()) {
            return false;
        }
        customerDAO.save(customer);

        return true;
    }

    @Override
    public boolean login(Customer customer) {
        String hql = "from Customer where id=" + customer.getId() + " and password='" + customer.getPassword() + "'";
        List list = customerDAO.query(hql);
        if (list.isEmpty()) {
            return false;
        } else {
            customer = (Customer) list.get(0);

            return true;
        }
    }

    @Override
    public void delete(Customer customer) {
        customer = getCustomerById(customer.getId());
        customerDAO.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);

    }

    @Override
    public void setFriend(Customer customer, Integer friendId) {
        customer = getCustomerById(customer.getId());
        Customer friend = getCustomerById(friendId);

        Set<Friend> friends = customer.getFriends();
        /* 现在已有朋友中找 */
        boolean flag = false;
        for (Friend myFriend : friends) {
            if (myFriend.getFriends().getId().equals(friendId)) {
                /* 找到就删去 */
                friends.remove(myFriend);
                flag = true;
                break;
            }
        }
        /* 找不到就添加 */
        if (!flag) {
            Friend newFriend = new Friend();
            newFriend.setCustomer(customer);
            newFriend.setFriends(friend);
            friends.add(newFriend);
        }

        customer.setFriends(friends);
    }

    public void reply(Discuss d){

    }

    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    private Customer getCustomerById(Integer id) {
        String hql = "from Customer where id=" + id;
        return (Customer) customerDAO.query(hql).get(0);
    }
}
