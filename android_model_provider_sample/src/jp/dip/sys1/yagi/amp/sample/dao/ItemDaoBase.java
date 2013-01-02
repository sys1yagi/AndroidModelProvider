package jp.dip.sys1.yagi.amp.sample.dao;

public class ItemDaoBase extends DAOBase {

    private String name;
    private String title;
    
    public ItemDaoBase() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
