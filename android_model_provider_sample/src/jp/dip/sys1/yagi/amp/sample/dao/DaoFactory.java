package jp.dip.sys1.yagi.amp.sample.dao;

import android.content.Context;
import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;

public class DaoFactory {

    private DBOpenHelper mDatabase;
    
    public DaoFactory(Context context) {
        mDatabase = new DBOpenHelper(context);
    }
    
    public <T> GenericDao<?> createDao(Class<T> clazz){
        if(clazz.equals(ItemDao.class)){
            return new ItemDao();
        }
        
        return null;
    }

}
