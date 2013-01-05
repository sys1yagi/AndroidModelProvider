package jp.dip.sys1.yagi.amp.sample.db;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.uphyca.testing.AndroidJUnit4TestAdapter;
import com.uphyca.testing.AndroidTestCase;

public class DBOpenHelperTest extends AndroidTestCase{
    /**
     * For Eclipse with ADT
     */
    public static junit.framework.Test suite() {
        return new AndroidJUnit4TestAdapter(DBOpenHelperTest.class);
    }
    private DBOpenHelper db = null;
    
    
    @Before
    public void setUp() throws Exception {
        //データベースを初期化する
        db = new DBOpenHelper(getContext());
        db.dropTables();
        db.onCreate(db.getWritableDatabase());
    }
    
    @Test
    public void dbがnullではない() {
        assertThat(db, is((not(equalTo(null)))));
    }
    

}
