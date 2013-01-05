package jp.dip.sys1.yagi.amp.sample.amp.model;

import jp.dip.sys1.yagi.amp.sample.amp.dao.Key;

/**
 * The Class RSSModel.
 * 
 * @author yagitoshihiro
 */
public class RSSModel {

    private Key<RSSModel> mKey = null;

    /** The Rss url. */
    private String mRssURL = null;

    /** The Last modified. */
    private Long mLastModified = 0L;

    /**
     * Instantiates a new rSS model.
     */
    public RSSModel() {
        
    }

    public Key<RSSModel> getKey() {
        return mKey;
    }

    public void setKey(Key<RSSModel> key) {
        mKey = key;
    }

    /**
     * Gets the rss url.
     * 
     * @return the rss url
     */
    public String getRssURL() {
        return mRssURL;
    }

    /**
     * Sets the rss url.
     * 
     * @param rssURL
     *            the new rss url
     */
    public void setRssURL(String rssURL) {
        mRssURL = rssURL;
    }

    /**
     * Gets the last modified.
     * 
     * @return the last modified
     */
    public Long getLastModified() {
        return mLastModified;
    }

    public void setLastModified(Long lastModified) {
        mLastModified = lastModified;
    }

}
