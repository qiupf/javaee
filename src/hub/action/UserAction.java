package hub.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hub.po.user.User;
import hub.service.IUserService;

import java.util.Map;

public class UserAction extends ActionSupport {
    private IUserService userService;
    private User user = new User();

    public UserAction() {

    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() {
        if (userService.login(user))
            return "success";
        else {
            this.addActionError("用户名或密码错误，请重新输入！");
            return "fail";
        }
    }
}
