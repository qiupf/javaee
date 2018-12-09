package hub.test;

import hub.dao.BaseDao;
import hub.dao.IUserDao;
import hub.po.admin.Admin;
import hub.po.user.User;
import hub.service.IUserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    /*private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
    private static Configuration configuration=new Configuration();
    private static SessionFactory sessionFactory;*/
    public static void main(String []args){
        /*configuration.configure(CONFIG_FILE_LOCATION);
        sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        User user=new User();
        user.setAccount("123");
        user.setPassword("123");
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        IUserService service= (IUserService) ctx.getBean("userService");
        IUserDao dao= (IUserDao) ctx.getBean("userDao");
        User user=new User();
        user.setAccount("123");
        user.setPassword("123");
        dao.updateUser(user);
       /* BaseDao dao= (BaseDao) ctx.getBean("baseDao");
        Session session=dao.getSession();
        User user=new User();
        user.setUserID(1);
        user.setAccount("111");
        user.setPassword("111");
        user.setName("qqqqqqq");
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();*/
    }

}
