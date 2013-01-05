/**
 * 
 */
package jp.dip.sys1.yagi.amp.sample.amp.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
public class RSSDaoBaseTest extends AndroidTestCase{

    /**
     * For Eclipse with ADT
     */
    public static junit.framework.Test suite() {
        return new AndroidJUnit4TestAdapter(RSSDaoBaseTest.class);
    }
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        //データベースを初期化する
        DBOpenHelper db = new DBOpenHelper(getContext());
        db.dropTables();
        db.onCreate(db.getWritableDatabase());
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void RSSを一件追加する() {
        DaoFactory factory = new DaoFactory(getContext());
        RSSModel model = new RSSModel();
        model.setRssURL("http://b.hatena.ne.jp/hotentry/it.rss");
        GenericDao<RSSModel> dao = factory.createDao(RSSModel.class);
        Key<RSSModel> key = dao.insert(model);
        assertThat(key, is(not(equalTo(null))));

        RSSModel selected = dao.selectFromKey(key);
        assertThat(selected.getKey().getId(), is(key.getId()));
    }

    //更新
    @Test
    public void RSSを一件更新する() throws Exception {
        fail("not yet implement.");
    }
    
    //削除
    @Test
    public void RSSを一件削除する() throws Exception {
        fail("not yet implement.");
    }
    
    
}
