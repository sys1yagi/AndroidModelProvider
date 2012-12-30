package jp.dip.sys1.yagi.amp.model;

public class ModelObject {
    private Class<?> clazz = null;
    
    public ModelObject(Class<?> clazz){
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }
    
}