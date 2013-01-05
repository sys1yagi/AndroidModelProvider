package jp.dip.sys1.yagi.amp.sample.db;

import jp.dip.sys1.yagi.amp.sample.amp.dao.DAOException;
import jp.dip.sys1.yagi.amp.sample.amp.dao.DaoFactory;
import jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao;
import jp.dip.sys1.yagi.amp.sample.amp.impl.ItemDao;
import jp.dip.sys1.yagi.amp.sample.amp.impl.RSSDao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * generated code.
 * @author AndroidModelProvider
 *
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    /** db name. */
    private final static String DB_NAME = "db";
    /** db version code. */
    private final static int VERSION = 1;

    
    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            initializeTable(db, new ItemDao(this));
            initializeTable(db, new RSSDao(this));
            db.setTransactionSuccessful();
        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private <T> void initializeTable(SQLiteDatabase db, GenericDao<T> dao) throws DAOException {
        if (!dao.create(db)) {
            throw new DAOException("create table error." + dao.getClass().getName());
        }
    }

    public void dropTables() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.beginTransaction();
            dropTable(db, new ItemDao(this));
            dropTable(db, new RSSDao(this));
            db.setTransactionSuccessful();
        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    private <T> void dropTable(SQLiteDatabase db, GenericDao<T> dao) throws DAOException {
        if (!dao.create(db)) {
            throw new DAOException("create table error." + dao.getClass().getName());
        }
    }
}
