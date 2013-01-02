package jp.dip.sys1.yagi.amp.sample.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.uphyca.testing.AndroidJUnit4TestAdapter;
import com.uphyca.testing.AndroidTestCase;

public class ItemDaoBaseTest extends AndroidTestCase{

    /**
     * For Eclipse with ADT
     */
    public static junit.framework.Test suite() {
        return new AndroidJUnit4TestAdapter(ItemDaoBaseTest.class);
    }
    @Test
    public void testGetName(){
        assertThat(10, is(10));
    }
}
