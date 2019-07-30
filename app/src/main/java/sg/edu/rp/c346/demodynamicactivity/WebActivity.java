package sg.edu.rp.c346.demodynamicactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setDisplayZoomControls(true);

        String url = getIntent().getStringExtra("url");
        Log.d("WebActivity", url);
        webView.setWebViewClient(new WebViewClient());

        if (!url.isEmpty()) {
            webView.loadUrl(url);
        } else {
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
