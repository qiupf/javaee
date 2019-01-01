package hub.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class BaseDao {
    private SessionFactory sessionFactory;
    public BaseDao(){}
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
