package jp.dip.sys1.yagi.amp.sample;

import jp.dip.sys1.yagi.amp.sample.amp.dao.DaoFactory;
import jp.dip.sys1.yagi.amp.sample.amp.dao.GenericDao;
import jp.dip.sys1.yagi.amp.sample.amp.model.RSSModel;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListFragment;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/**
 * RSSリーダーアプリ
 * @author yagitoshihiro
 *
 */
public class MainActivity extends Activity {
    
    private ListFragment mListFragment;
    private DaoFactory mDaoFactory;
    /**
     get this object for enclosing objects.
     @return MainActivity this object.
     */
    public MainActivity This() {
        return this;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDaoFactory = new DaoFactory(this);
        setContentView(R.layout.activity_main);
        initializeListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void initializeListView(){
        GenericDao<RSSModel> dao = mDaoFactory.createDao(RSSModel.class);
        dao.selectAll();
        mListFragment = (ListFragment)getFragmentManager().findFragmentById(R.id.rss_list);
        mListFragment.setListAdapter(new ListAdapter() {
            @Override
            public void unregisterDataSetObserver(DataSetObserver arg0) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void registerDataSetObserver(DataSetObserver arg0) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public boolean isEmpty() {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public boolean hasStableIds() {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public int getViewTypeCount() {
                return 1;
            }
            
            @Override
            public View getView(int arg0, View arg1, ViewGroup arg2) {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public int getItemViewType(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public Object getItem(int arg0) {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public boolean isEnabled(int position) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public boolean areAllItemsEnabled() {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }
}
