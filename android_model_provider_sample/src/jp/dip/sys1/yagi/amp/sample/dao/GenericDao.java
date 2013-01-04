package jp.dip.sys1.yagi.amp.sample.dao;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public abstract class GenericDao<T> {
    abstract public boolean create(SQLiteDatabase db);
    abstract public boolean drop(SQLiteDatabase db);
    abstract public T selectFromKey(Key<T> pk);
    abstract public List<T> selectAll();
    abstract public boolean delete(T entity);    
    abstract public boolean insert(T entity);
    abstract public boolean update(T entity);
}
