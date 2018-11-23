package tw.com.lccnet.app.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView wv;
    private long exittime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv=new WebView(this);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                view.loadUrl(request);
                return true;
            }
        });
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://tw.yahoo.com");
        setContentView(wv);

    }

    @Override
    public void onBackPressed() {
        if(wv.canGoBack()){
        wv.goBack();
        }else{

        if(System.currentTimeMillis()-exittime>2000){
            Toast.makeText(getApplicationContext(),"在按一次退出程序",Toast.LENGTH_LONG).show();
            exittime=System.currentTimeMillis();
        }else{
            super.onBackPressed();
            }
        }

    }
}
