package jp.dip.sys1.yagi.amp.sample.amp.dao;

import java.util.List;

import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;
import android.database.sqlite.SQLiteDatabase;

/*
 * generated code.
 *
 * @param <T> Model Object Type
 * @author yagitoshihiro
 */
public abstract class GenericDao<T> {
    /**
     * SQLite data types.
     */
    public enum COLUMN_TYPE{
        
        /** The integer. */
        INTEGER,
        
        /** The blob. */
        BLOB,
        
        /** The text. */
        TEXT,
        
        /** The null. */
        NULL,
        
        /** The real. */
        REAL,
    }    
    private DBOpenHelper mDb;
    
    public GenericDao(DBOpenHelper db){
        this.mDb = db;
    }
    
    protected DBOpenHelper getDBOpenHelper(){
        return this.mDb;
    }
    
    /**
     * Gets the table name.
     *
     * @return the table name
     */
    abstract public String getTableName();
    
    /**
     * Creates the.
     *
     * @param db the db
     * @return true, if successful
     */
    abstract public boolean create(SQLiteDatabase db);
    
    /**
     * Drop.
     *
     * @param db the db
     * @return true, if successful
     */
    abstract public boolean drop(SQLiteDatabase db);
    
    
    /**
     * Select from key.
     *
     * @param pk the pk
     * @return the t
     */
    public T selectFromKey(Key<T> pk){
        return null;
    }
    
    /**
     * Select all.
     *
     * @return the list
     */
    public List<T> selectAll(){
        return null;
    }
    
    /**
     * Delete.
     *
     * @param entity the entity
     * @return true, if successful
     */
    public boolean delete(T entity){
        return false;
    }
    
    /**
     * Insert.
     *
     * @param entity the entity
     * @return true, if successful
     */
    public Key<T> insert(T entity){
        return null;
    }
    
    /**
     * Update.
     *
     * @param entity the entity
     * @return true, if successful
     */
    public boolean update(T entity){
        return false;
    }
}
