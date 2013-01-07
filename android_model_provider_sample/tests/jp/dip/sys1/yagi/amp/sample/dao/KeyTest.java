package jp.dip.sys1.yagi.amp.sample.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import jp.dip.sys1.yagi.amp.sample.amp.dao.Key;
import jp.dip.sys1.yagi.amp.sample.amp.impl.ItemDao;

import org.junit.Test;

import com.uphyca.testing.AndroidJUnit4TestAdapter;
import com.uphyca.testing.AndroidTestCase;

public class KeyTest extends AndroidTestCase{
    /**
     * For Eclipse with ADT
     */
    public static junit.framework.Test suite() {
        return new AndroidJUnit4TestAdapter(KeyTest.class);
    }

    @Test
    public void コンストラクタにセットした_idをgetIdして一致する事を確認する() {
        Key<ItemDao> key = new Key<ItemDao>(1L);
        assertThat(1L, is(key.getId()));
    }

}
