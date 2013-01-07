package jp.dip.sys1.yagi.amp.sample.amp.dao;

/**
 * 主キーを表すクラス
 * 
 * @author yagitoshihiro
 * 
 */
public class Key<T> {

    private long _id = -1L;

    public Key(long _id) {
        this._id = _id;
    }

    public long getId() {
        return _id;
    }
}
