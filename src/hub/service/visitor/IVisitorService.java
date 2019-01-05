package hub.service.visitor;

import hub.po.customer.Customer;

import java.util.List;

public interface IVisitorService {
    boolean register(Customer customer);        //注册
    boolean login(Customer customer);           //登录
    List getModels();                   //获取所有话题
    List getTopics(Integer mid);        //根据模块获取所有话题
    List getFloors(Integer tid);        //根据话题获取所有楼层
    Customer getCustomerById(Integer id);
}
