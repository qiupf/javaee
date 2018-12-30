package hub.test;

import hub.dao.BaseDao;
import hub.dao.IUserDao;
import hub.po.admin.Admin;
import hub.po.discuss.Discuss;
import hub.po.topic.Topic;
import hub.po.user.User;
import hub.service.IModelService;
import hub.service.ITopicService;
import hub.service.IUserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        IModelService test= (IModelService) ctx.getBean("modelService");
        ITopicService topic= (ITopicService) ctx.getBean("topicService");
        List<Discuss> dis=topic.getDisscuss(1);
        List<Topic> kk=test.getTopics(1);
        for(Discuss t:dis){
            System.out.println(t.getId());
        }

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
