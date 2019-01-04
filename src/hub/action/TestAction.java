package hub.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hub.po.customer.Customer;
import hub.service.admin.IAdminService;
import hub.service.customer.ICustomerService;
import hub.service.visitor.IVisitorService;

import java.util.List;
import java.util.Map;

public class TestAction extends ActionSupport {
    private ICustomerService customerService;
    private IAdminService adminService;
    private IVisitorService visitorService;
    private Map session;
    private Map params;

    public String test(){
        params = ActionContext.getContext().getParameters();
        try {
            String ModelId=((String[]) params.get("modelId"))[0];
            System.out.println(ModelId);
            System.out.println("sssssssssssssss");
            System.out.println("asasasasasas");
            System.out.println(ModelId);
            System.out.println(ModelId);
        }catch (Exception e){
            System.out.println("没有找到");
            return "modifyImgFail";
        }
        session= ActionContext.getContext().getSession();
        List topics=visitorService.getTopics(1);
        session.put("topics",topics);
        return "success";
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public IAdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    public IVisitorService getVisitorService() {
        return visitorService;
    }

    public void setVisitorService(IVisitorService visitorService) {
        this.visitorService = visitorService;
    }
}
