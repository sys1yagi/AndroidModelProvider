package jp.dip.sys1.yagi.amp.sample.db;

import jp.dip.sys1.yagi.amp.sample.dao.DAOException;
import jp.dip.sys1.yagi.amp.sample.dao.GenericDao;
import jp.dip.sys1.yagi.amp.sample.dao.ItemDao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "db";
    private final static int VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            initializeTable(db, new ItemDao());
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

    private void dropTables() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.beginTransaction();
            dropTable(db, new ItemDao());
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
