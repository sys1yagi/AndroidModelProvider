package jp.dip.sys1.yagi.amp.sample.amp.dao;

import android.content.Context;
import jp.dip.sys1.yagi.amp.sample.amp.impl.ItemDao;
import jp.dip.sys1.yagi.amp.sample.amp.impl.RSSDao;
import jp.dip.sys1.yagi.amp.sample.amp.model.ItemModel;
import jp.dip.sys1.yagi.amp.sample.amp.model.RSSModel;
import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;

/**
 * generated code.
 * @author AndroidModelProvider
 *
 */
public class DaoFactory {

    private DBOpenHelper mDatabase;
    
    public DaoFactory(Context context) {
        mDatabase = new DBOpenHelper(context);
    }
    
    @SuppressWarnings("unchecked")
    public <T> GenericDao<T> createDao(Class<T> clazz){
        if(clazz.equals(ItemModel.class)){
            return (GenericDao<T>)new ItemDao(mDatabase);
        }
        else if(clazz.equals(RSSModel.class)){
            return (GenericDao<T>)new RSSDao(mDatabase);
        }
        
        return null;
    }

}
