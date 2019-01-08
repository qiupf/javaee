package hub.interceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class FloorInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ctx = actionInvocation.getInvocationContext();
        Map params = ActionContext.getContext().getParameters();
        if (params.get("topicId") != null) {
            return actionInvocation.invoke();
        } else {
            return "loadTopic";
        }
    }
}
