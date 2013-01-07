package jp.dip.sys1.yagi.amp.sample.amp.dao;

import java.util.List;

import jp.dip.sys1.yagi.amp.sample.amp.model.IModel;
import jp.dip.sys1.yagi.amp.sample.amp.model.RSSModel;
import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/*
 * generated code.
 *
 * @param <T> Model Object Type
 * @author yagitoshihiro
 */
public abstract class GenericDao<T> {
    private final static String TAG = GenericDao.class.getSimpleName();

    /**
     * SQLite data types.
     */
    public enum COLUMN_TYPE {

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

    public GenericDao(DBOpenHelper db) {
        this.mDb = db;
    }

    protected DBOpenHelper getDBOpenHelper() {
        return this.mDb;
    }

    protected static String getKeyName() {
        return "_id";
    }

    /**
     * Select from key.
     * 
     * @param pk
     *            the pk
     * @return the t
     */
    public T selectFromKey(Key<T> pk) {
        SQLiteDatabase db = getDBOpenHelper().getWritableDatabase();
        Cursor cursor = db.query(getTableName(), getColumns(), getKeyName() + "=?", new String[] { Long.toString(pk.getId()) }, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.getCount() > 1) {
                    Log.w(TAG, "select item counts > 1.");
                }
                // RSSModel model = new RSSModel();
                // IModel model

                cursor.moveToNext();
                T model = newInstance();
                if (!initFromCursor(model, cursor)) {
                    // TODO error message
                }
                return model;
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    /**
     * Select all.
     * 
     * @return the list
     */
    public List<T> selectAll() {
        return null;
    }

    /**
     * Delete.
     * 
     * @param entity
     *            the entity
     * @return true, if successful
     */
    public boolean delete(T entity) {
        return false;
    }

    /**
     * Insert.
     * 
     * @param entity
     *            the entity
     * @return true, if successful
     */
    public Key<T> insert(T entity) {
        SQLiteDatabase db = getDBOpenHelper().getWritableDatabase();
        try {
            db.beginTransaction();
            long id = db.insert(getTableName(), null, createContentValues(entity));
            if (id != -1) {
                db.setTransactionSuccessful();
                return createKey(id);
            }
        } finally {
            db.endTransaction();
        }
        return null;
    }

    /**
     * Update.
     * 
     * @param entity
     *            the entity
     * @return true, if successful
     */
    public boolean update(T entity) {
        return false;
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
     * @param db
     *            the db
     * @return true, if successful
     */
    abstract public boolean create(SQLiteDatabase db);

    /**
     * Drop.
     * 
     * @param db
     *            the db
     * @return true, if successful
     */
    abstract public boolean drop(SQLiteDatabase db);

    /**
     * 
     * @return
     */
    abstract protected ContentValues createContentValues(T entity);

    abstract protected Key<T> createKey(long id);

    abstract protected T newInstance();

    abstract protected String[] getColumns();

    abstract protected boolean initFromCursor(T model, Cursor cursor);
}
