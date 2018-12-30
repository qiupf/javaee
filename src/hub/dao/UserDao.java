package hub.dao;

import hub.po.user.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends BaseDao implements IUserDao {

    @Override
    public User getUserByAccount(String userID) {
        return getSession().get(User.class, userID);
    }

    @Override
    public List findByHql(String hql) {
        try {
            Query queryObject = getSession().createQuery(hql);
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            getSession().update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
