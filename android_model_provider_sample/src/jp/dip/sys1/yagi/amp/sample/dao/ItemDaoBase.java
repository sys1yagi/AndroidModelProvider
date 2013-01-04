package jp.dip.sys1.yagi.amp.sample.dao;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public class ItemDaoBase extends GenericDao<Item> {
    private static String TABLE_NAME = "item";
    
    @Override
    public boolean create(SQLiteDatabase db) {
        
        return false;
    }
    @Override
    public boolean drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        return false;
    }
    @Override
    public boolean delete(Item entity) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean insert(Item entity) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public List<Item> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Item selectFromKey(Key<Item> pk) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean update(Item entity) {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}
