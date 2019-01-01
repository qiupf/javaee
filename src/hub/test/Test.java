package hub.test;

import hub.po.customer.Customer;
import hub.po.floor.Floor;
import hub.po.floorDiscuss.FloorDiscuss;
import hub.po.letter.Letter;
import hub.service.customer.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    /*private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
        private static Configuration configuration=new Configuration();
        private static SessionFactory sessionFactory;*/
    public static void main(String[] args) {
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ICustomerService test = (ICustomerService) ctx.getBean("customerService");
       /* Customer c = new Customer();
        c.setId(1);
        FloorDiscuss f=new FloorDiscuss();
        f.setDetail("是这个意思");
        test.inFloorReply(c,1,1,f);*/
        test.praise(1);


        /*ITopicService topic= (ITopicService) ctx.getBean("topicService");
        List<Topic> kk=test.getTopics(1);
        for(Topic t:kk){
            System.out.println(t.getId());
        }*/

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
