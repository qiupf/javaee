package hub.service.admin;

import hub.dao.IBasicDAO;
import hub.po.model.Model;

public class AdminService implements IAdminService{
    private IBasicDAO basicDAO;



    public IBasicDAO getBasicDAO() {
        return basicDAO;
    }

    public void setBasicDAO(IBasicDAO basicDAO) {
        this.basicDAO = basicDAO;
    }

    @Override
    public void addModel(Model model) {

    }

    @Override
    public void delModel(Integer mid) {

    }

    @Override
    public void ban(Integer cid) {

    }

    @Override
    public void top(Integer tid) {

    }
}
