package jp.dip.sys1.yagi.amp.sample.amp.dao;

/**
 * 主キーを表すクラス
 * 
 * @author yagitoshihiro
 * 
 */
public class Key<T> {

    private String _id = null;

    public Key(String _id) {
        this._id = _id;
    }

    public String getId() {
        return _id;
    }
}
