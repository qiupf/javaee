package hub.service;

import hub.dao.IModelDAO;
import hub.po.model.Model;
import hub.po.topic.Topic;

import java.util.*;

public class ModelService implements IModelService{
    private IModelDAO modelDAO;
    @Override
    public List getAllModels() {
        String hql="from Model";
        return modelDAO.findByHql(hql);
    }
    @Override
    public List getTopics(int modelId){
        Model model=modelDAO.fingById(modelId);
        Set temp=model.getTopics();
        List topics=new ArrayList (temp);
        Collections.sort(topics);
        return topics;
    }

    public IModelDAO getModelDAO() {
        return modelDAO;
    }

    public void setModelDAO(IModelDAO modelDAO) {
        this.modelDAO = modelDAO;
    }
}
