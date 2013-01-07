package jp.dip.sys1.yagi.amp.sample.amp.dao;

/**
 * 
 * @author yagitoshihiro
 *
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String detailMessage) {
        super(detailMessage);
    }

    public DAOException(Throwable throwable) {
        super(throwable);
    }

    public DAOException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
