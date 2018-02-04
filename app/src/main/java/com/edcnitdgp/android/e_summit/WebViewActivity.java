package com.edcnitdgp.android.e_summit;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by Dell on 02-Feb-18.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView myWebView;
    private ProgressBar progressBar;
    private ImageView imgHeader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String url = getIntent().getStringExtra("url");
        myWebView = (WebView) findViewById(R.id.webview);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(progressBar.getProgress());
        imgHeader = (ImageView) findViewById(R.id.backdrop);
        // initializing toolbar
        initCollapsingToolbar();
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(url);
        myWebView.setHorizontalScrollBarEnabled(false);
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar txtPostTitle on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Web View");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the txtPostTitle when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Web View");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });


    }
}
