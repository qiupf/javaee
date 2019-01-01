package hub.service.visitor;

import java.util.List;

public interface IVisitorService {
    List getModels();                   //获取所有话题
    List getTopics(Integer mid);        //根据模块获取所有话题
    List getFloors(Integer tid);        //根据话题获取所有楼层
}
