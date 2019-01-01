package hub.service.admin;

import hub.dao.IBasicDAO;

public class AdminService {
    private IBasicDAO basicDAO;

    public IBasicDAO getBasicDAO() {
        return basicDAO;
    }

    public void setBasicDAO(IBasicDAO basicDAO) {
        this.basicDAO = basicDAO;
    }
}
