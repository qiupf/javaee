package hub.service;

import hub.dao.IDiscussDAO;

public class DiscussService implements IDiscussService{
    private IDiscussDAO discussDAO;

    public IDiscussDAO getDiscussDAO() {
        return discussDAO;
    }

    public void setDiscussDAO(IDiscussDAO discussDAO) {
        this.discussDAO = discussDAO;
    }
}
