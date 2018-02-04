package com.edcnitdgp.android.e_summit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dell on 27-Jan-18.
 */

public class StartupWorkshopActivity extends AppCompatActivity {
    public ImageView eventPoster;
    public TextView eventHeading;
    public TextView eventInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_internal_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eventPoster=findViewById(R.id.event_poster);
        eventHeading=findViewById(R.id.event_heading);
        eventInfo=findViewById(R.id.event_info);
        eventPoster.setImageResource(R.drawable.ecell_nitdgp);
        eventInfo.setText(R.string.startup_workshop_info);
        eventHeading.setText("Startup Worskshop-Alley");
    }
}
