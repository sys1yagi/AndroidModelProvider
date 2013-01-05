/**
 * 
 */
package jp.dip.sys1.yagi.amp.sample.amp.dao;

import static jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao.COLUMN_TYPE.INTEGER;
import static jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao.COLUMN_TYPE.TEXT;
import jp.dip.sys1.yagi.amp.sample.amp.model.RSSModel;
import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * generated code
 * 
 * @author yagitoshihiro
 * 
 */
public class RSSDaoBase extends GenericDao<RSSModel> {
    private final static String TAG = RSSDaoBase.class.getSimpleName();

    private static final String TABLE_NAME = "rss";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_RSS_URL = "rss_url";
    private static final String COLUMN_LAST_MODIFIED = "last_modified";

    private static final String[] COLUMNS = new String[] { COLUMN_ID, COLUMN_RSS_URL, COLUMN_LAST_MODIFIED, };

    /**
     * 
     */
    public RSSDaoBase(DBOpenHelper db) {
        super(db);
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#getTableName()
     */
    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#create(android.database
     * .sqlite.SQLiteDatabase)
     */
    @Override
    public boolean create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + " " + COLUMN_ID + " " + INTEGER + " PRIMARY KEY AUTOINCREMENT" + "," + COLUMN_RSS_URL + " " + TEXT + " NOT NULL" + "," + COLUMN_LAST_MODIFIED + " " + INTEGER + " NOT NULL" + ")");
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#drop(android.database.
     * sqlite.SQLiteDatabase)
     */
    @Override
    public boolean drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#insert(java.lang.Object)
     */
    @Override
    public Key<RSSModel> insert(RSSModel entity) {
        SQLiteDatabase db = getDBOpenHelper().getWritableDatabase();
        try {
            db.beginTransaction();
            ContentValues values = new ContentValues();
            values.put(COLUMN_RSS_URL, entity.getRssURL());
            values.put(COLUMN_LAST_MODIFIED, entity.getLastModified());
            long id = db.insert(TABLE_NAME, null, values);
            if (id != -1) {
                db.setTransactionSuccessful();
                return new Key<RSSModel>(Long.toString(id));
            }
        } finally {
            db.endTransaction();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#selectFromKey(jp.dip.sys1
     * .yagi.amp.sample.amp.dao.Key)
     */
    @Override
    public RSSModel selectFromKey(Key<RSSModel> pk) {
        SQLiteDatabase db = getDBOpenHelper().getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, COLUMNS, COLUMN_ID + "=?", new String[] { pk.getId() }, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.getCount() > 1) {
                    Log.w(TAG, "select item counts > 1.");
                }
                RSSModel model = new RSSModel();
                cursor.moveToNext();
                model.setKey(new Key<RSSModel>(Long.toString(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))));
                model.setRssURL(cursor.getString(cursor.getColumnIndex(COLUMN_RSS_URL)));
                model.setLastModified(cursor.getLong(cursor.getColumnIndex(COLUMN_LAST_MODIFIED)));
                return model;
            } finally {
                cursor.close();
            }
        }
        return null;
    }
}
