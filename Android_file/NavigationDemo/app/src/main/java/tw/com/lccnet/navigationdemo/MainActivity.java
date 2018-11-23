package tw.com.lccnet.navigationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {
    BottomBar mbottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mbottomBar=findViewById(R.id.bottombar);
        mbottomBar.setOnTabSelectListener(new OnTabSelectListener() {
        @Override
        public void onTabSelected(int tabId) {

        }
    });
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings0) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
