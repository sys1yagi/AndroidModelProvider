package jp.dip.sys1.yagi.amp.sample;

import jp.dip.sys1.yagi.amp.annotation.Attribute;
import jp.dip.sys1.yagi.amp.annotation.Model;

@Model
public class Sample2 {
    @Attribute(primaryKey=true)
    private int id = 0; 
    
    private String version = null;
    
    @Attribute(persistence=false)
    private String moge = null;
}
