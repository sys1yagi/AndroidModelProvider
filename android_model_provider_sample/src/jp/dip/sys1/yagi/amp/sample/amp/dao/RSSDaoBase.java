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

/**
 * generated code
 * 
 * @author yagitoshihiro
 * 
 */
public abstract class RSSDaoBase extends GenericDao<RSSModel> {

    private static final String TABLE_NAME = "rss";

    private static final String COLUMN_RSS_URL = "rss_url";
    private static final String COLUMN_LAST_MODIFIED = "last_modified";

    private static final String[] COLUMNS = new String[] { getKeyName(), COLUMN_RSS_URL, COLUMN_LAST_MODIFIED, };

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
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + " " + getKeyName() + " " + INTEGER + " PRIMARY KEY AUTOINCREMENT" + "," + COLUMN_RSS_URL + " " + TEXT + " NOT NULL" + "," + COLUMN_LAST_MODIFIED + " " + INTEGER + " NOT NULL" + ")");
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
     * @see jp.dip.sys1.yagi.amp.sample.amp.model.IModel#createContentValues()
     */
    @Override
    protected ContentValues createContentValues(RSSModel entity) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_RSS_URL, entity.getRssURL());
        values.put(COLUMN_LAST_MODIFIED, entity.getLastModified());
        return values;
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#createKey(long)
     */
    @Override
    protected Key<RSSModel> createKey(long id) {
        return new Key<RSSModel>(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#newInstance()
     */
    @Override
    protected RSSModel newInstance() {
        return new RSSModel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#getColumns()
     */
    @Override
    protected String[] getColumns() {
        return COLUMNS;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#initFromCursor(java.lang
     * .Object, android.database.Cursor)
     */
    @Override
    protected boolean initFromCursor(RSSModel model, Cursor cursor) {
        // TODO error check
        model.setKey(new Key<RSSModel>(cursor.getLong(cursor.getColumnIndex(getKeyName()))));
        model.setRssURL(cursor.getString(cursor.getColumnIndex(COLUMN_RSS_URL)));
        model.setLastModified(cursor.getLong(cursor.getColumnIndex(COLUMN_LAST_MODIFIED)));
        return true;
    }
}
