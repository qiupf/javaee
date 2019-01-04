package hub.service.admin;

import hub.po.model.Model;

public interface IAdminService {
    void addModel(Model model);
    void delModel(Integer mid);
    void ban(Integer cid);
    void top(Integer tid);
}
