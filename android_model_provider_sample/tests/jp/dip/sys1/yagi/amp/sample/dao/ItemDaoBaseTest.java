package jp.dip.sys1.yagi.amp.sample.dao;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ItemDaoBaseTest{

    @Test
    public void testGetName(){
        assertThat(10, is(10));
    }
    @Test
    public void 足し算5_plus_5(){
        assertThat(5+5, is(10));
    }
    @Test
    public void 足し算5_plus_10(){
        assertThat(5+10, is(15));
    }
}
