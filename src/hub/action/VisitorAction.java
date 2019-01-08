package hub.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hub.po.customer.Customer;
import hub.po.floor.Floor;
import hub.po.model.Model;
import hub.po.topic.Topic;
import hub.service.visitor.IVisitorService;

import java.util.List;
import java.util.Map;

public class VisitorAction extends ActionSupport {
    private IVisitorService visitorService;
    private Customer loginUser = new Customer();
    private Map session;
    private Map params;

    //注册
    public String register() {
        if (visitorService.register(loginUser)) {
            return "registerSuccess";
        }
        return "registerFail";
    }

    //登录
    public String login() {
        if (visitorService.login(loginUser)) {
            return "loginSuccess";
        }
        this.addActionError("用户名或密码错误，请重新输入！");
        return "loginFail";
    }

    //加载模块
    public String loadModel() {
        session = ActionContext.getContext().getSession();
        List models = visitorService.getModels();
        session.put("models", models);
        System.out.println(models);
        return "loadModelSuccess";
    }

    //根据模块Id加载相应的话题
    public String loadTopic() {
        params = ActionContext.getContext().getParameters();
        session = ActionContext.getContext().getSession();
        try {
            String modelId = ((String[]) params.get("modelId"))[0];
            List topics = visitorService.getTopics(Integer.valueOf(modelId));
            Model model = visitorService.getModelById(Integer.valueOf(modelId));
            session.put("topics", topics);
            session.put("model", model);
            return "loadTopicSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("没有找到");
            return "loadTopicFail";
        }
    }

    public String loadFloor() {
        params = ActionContext.getContext().getParameters();
        session = ActionContext.getContext().getSession();
        try {
            String topicId = ((String[]) params.get("topicId"))[0];
            System.out.println(topicId);
            List floors = visitorService.getFloors(Integer.valueOf(topicId));
            Topic topic = visitorService.getTopicById(Integer.valueOf(topicId));
            session.put("floors", floors);
            session.put("topic", topic);
            return "loadFloorSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "loadFloorFail";
        }
    }


    /*public void validateLogin() {
        Integer account = loginUser.getId();
        String password = loginUser.getPassword();
        if (account == null)
            this.addFieldError("loginUser.id", "账号不能为空");
        if (password == null || password.equals(""))
            this.addFieldError("loginUser.password", "密码不能为空");
    }*/

    public IVisitorService getVisitorService() {
        return visitorService;
    }

    public void setVisitorService(IVisitorService visitorService) {
        this.visitorService = visitorService;
    }

    public Customer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Customer loginUser) {
        this.loginUser = loginUser;
    }
}
