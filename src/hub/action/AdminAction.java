package hub.action;

import com.opensymphony.xwork2.ActionSupport;
import hub.po.admin.Admin;
import hub.service.admin.IAdminService;

public class AdminAction extends ActionSupport {
    private IAdminService adminService;
    private Admin admin;

    private AdminAction() {
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public IAdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }
}
