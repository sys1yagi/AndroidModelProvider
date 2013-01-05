package jp.dip.sys1.yagi.amp.sample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
/**
 * RSSリーダーアプリ
 * @author yagitoshihiro
 *
 */
public class MainActivity extends Activity {
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
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
