package com.edcnitdgp.android.e_summit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

/**
 * Created by Dell on 27-Jan-18.
 */

public class ContactUsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ImageButton fbImageButton = (ImageButton) findViewById(R.id.fb_logo);
        final ImageButton instaImageButton = (ImageButton) findViewById(R.id.insta_logo);
        final ImageButton youtubeImageButton = (ImageButton) findViewById(R.id.youtube_logo);
        final Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        fbImageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                intent.putExtra("url", "https://www.facebook.com/nen.nitd/");
                startActivity(intent);
            }

        });
        instaImageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                intent.putExtra("url", "https://www.instagram.com/edc.nitd/");
                startActivity(intent);


            }

        });
        youtubeImageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                intent.putExtra("url", "https://www.youtube.com/channel/UCaBiTXfp5gknGPS6N3asDBg");
                startActivity(intent);

            }

        });

    }
//    public void onClick(View v)
//    {
//        WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        final Context context = this;
//        Intent intent = new Intent(context, SecondActivity.class);
//        startActivity(intent);
//        switch(v.getId())
//        {
//            case R.id.button1:
//                myWebView.loadUrl("https://www.youtube.com/channel/UCaBiTXfp5gknGPS6N3asDBg");
//                break;
//
//            case R.id.button2:
//                myWebView.loadUrl("http://www.bestchance.org.au/");
//                break;
//
//            default:
//                break;
//        }
//
//
//    }
}
