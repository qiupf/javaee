package hub.service;

import java.util.List;

public interface IModelService {
    public List getAllModels();
    public List getTopics(int modelId);
}
