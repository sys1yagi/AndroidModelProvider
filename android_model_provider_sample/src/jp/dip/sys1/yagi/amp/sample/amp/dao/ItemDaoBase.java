package jp.dip.sys1.yagi.amp.sample.amp.dao;

import jp.dip.sys1.yagi.amp.sample.amp.model.ItemModel;
import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import static jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao.COLUMN_TYPE.*;

/**
 * generated code.
 * @author yagitoshihiro
 *
 */
public abstract class ItemDaoBase extends GenericDao<ItemModel> {
    private static final String TABLE_NAME = "item";
    private static final String COLUMN_ID = "_id";
    
    public ItemDaoBase(DBOpenHelper db){
        super(db);
    }
    
    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
    
    @Override
    public boolean create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "("
                + " " + COLUMN_ID + " " + INTEGER + " PRIMARY KEY AUTOINCREMENT"
                + ")"
                );
        return true;
    }
    @Override
    public boolean drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        return true;
    }
    /* (non-Javadoc)
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#createContentValues(java.lang.Object)
     */
    @Override
    public ContentValues createContentValues(ItemModel entity) {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#createKey(long)
     */
    @Override
    protected Key<ItemModel> createKey(long id) {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#newInstance()
     */
    @Override
    protected ItemModel newInstance() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#getColumns()
     */
    @Override
    protected String[] getColumns() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao#initFromCursor(java.lang.Object, android.database.Cursor)
     */
    @Override
    protected boolean initFromCursor(ItemModel model, Cursor cursor) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
