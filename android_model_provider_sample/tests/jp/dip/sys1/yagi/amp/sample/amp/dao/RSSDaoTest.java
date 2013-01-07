/**
 * 
 */
package jp.dip.sys1.yagi.amp.sample.amp.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import jp.dip.sys1.yagi.amp.sample.amp.model.RSSModel;
import jp.dip.sys1.yagi.amp.sample.db.DBOpenHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uphyca.testing.AndroidJUnit4TestAdapter;
import com.uphyca.testing.AndroidTestCase;

/**
 * @author yagitoshihiro
 *
 */
public class RSSDaoTest extends AndroidTestCase{

    /**
     * For Eclipse with ADT
     */
    public static junit.framework.Test suite() {
        return new AndroidJUnit4TestAdapter(RSSDaoTest.class);
    }
    
    private GenericDao<RSSModel> mDao;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        //データベースを初期化する
        DBOpenHelper db = new DBOpenHelper(getContext());
        db.dropTables();
        db.onCreate(db.getWritableDatabase());
        db.close();
        
        DaoFactory factory = new DaoFactory(getContext());
        mDao = factory.createDao(RSSModel.class);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
    private Key<RSSModel> insertModel(String url){
        if(url == null){
            url = "http://b.hatena.ne.jp/hotentry/it.rss";
        }
        RSSModel model = new RSSModel();
        model.setRssURL(url);
        return mDao.insert(model);
    }

    //追加
    @Test
    public void RSSModelを一件追加する() {
        Key<RSSModel> key = insertModel(null);
        assertThat(key, is(not(equalTo(null))));
    }
    
    @Test
    public void RSSModelを一件選択する() throws Exception {
        Key<RSSModel> key = insertModel(null);
        assertThat(key, is(not(equalTo(null))));
        RSSModel selected = mDao.selectFromKey(key);
        assertThat(selected.getKey().getId(), is(key.getId()));
    }

    //更新
    /*
    @Test
    public void RSSを一件更新する() throws Exception {
        Key<RSSModel> key = insertModel(null);
        assertThat(key, is(not(equalTo(null))));
        
        RSSModel selected = mDao.selectFromKey(key);
        assertThat(selected, is(not(equalTo(null))));
        assertThat(selected.getKey().getId(), is(key.getId()));
        
        long updateValue = 1000L;
        selected.setLastModified(updateValue);
        assertThat(mDao.update(selected), is(equalTo(true)));
        
        selected = mDao.selectFromKey(key);
        assertThat(selected, is(not(equalTo(null))));
        assertThat(selected.getKey().getId(), is(key.getId()));
        
        assertThat(selected.getLastModified(), is(equalTo(updateValue)));
    }
    */
    
    //削除
    /*
    @Test
    public void RSSModelを一件削除する() throws Exception {
        fail("not yet implement.");
    }
    */
    
    
}
