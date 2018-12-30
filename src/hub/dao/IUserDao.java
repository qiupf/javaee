package hub.dao;

import hub.po.user.User;
import org.hibernate.Session;

import java.util.List;

public interface IUserDao{
    public User getUserByAccount(String account);
    public List findByHql(String hql);
    public boolean updateUser(User user);
    public Session getSession();
}
