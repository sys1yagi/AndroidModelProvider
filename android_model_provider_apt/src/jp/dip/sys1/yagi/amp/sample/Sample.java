package jp.dip.sys1.yagi.amp.sample;

import jp.dip.sys1.yagi.amp.annotation.Attribute;
import jp.dip.sys1.yagi.amp.annotation.Model;

@Model
public class Sample {
    
    @Attribute(primaryKey=true)
    private int id = 0;
    
    
    private String name = null;
    
    @Attribute(persistence=false)
    private String displayName = null;
    
    
    public void Ugoo(){
        
    }
}
