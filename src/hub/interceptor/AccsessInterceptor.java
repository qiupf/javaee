package hub.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/*用来检验访问Action的某个方法时，用户是否登录*/
public class AccsessInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ctx = actionInvocation.getInvocationContext();
        Map session = ctx.getSession();
        if (session.get("customer") != null) {
            return actionInvocation.invoke();
        } else {
            return Action.LOGIN;
        }
    }
}
