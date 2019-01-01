package hub.po.model;

import hub.po.favorModel.FavorModel;
import hub.po.topic.Topic;

import java.util.Set;

public class Model implements Comparable<Model>{
    private Integer id;
    private String name;
    private String image;
    private String description;

    /* 一对多 */
    private Set<Topic> topics;//查话题 级联删除属于该模块的话题
    private Set<FavorModel> favorModels;//被关注 级联删除被关注的模块

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public Set<FavorModel> getFavorModels() {
        return favorModels;
    }

    public void setFavorModels(Set<FavorModel> favorModels) {
        this.favorModels = favorModels;
    }

    @Override
    public int compareTo(Model o) {
        return o.id-this.id;
    }
}
