package hub.dao;

import hub.po.user.User;

import java.util.List;

public interface IUserDao{
    public User getUserByAccount(String account);
    public List findByHql(String hql);
    public boolean updateUser(User user);
}
