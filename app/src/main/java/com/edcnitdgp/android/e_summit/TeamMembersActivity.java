package com.edcnitdgp.android.e_summit;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Dell on 26-Jan-18.
 */

public class TeamMembersActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_recycler_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Events> events = new ArrayList<Events>();
        events.add(new Events("Auction Arcadia",R.drawable.auction_arcadia_poster,1));
        events.add(new Events("Startup Workshop-Alley",R.drawable.ecell_nitdgp,2));
        events.add(new Events("Panel Discussion",R.drawable.ecell_nitdgp,3));
        events.add(new Events("E-Talks",R.drawable.e_talks1,4));
        events.add(new Events("Entre-writeup",R.drawable.entre_writeup_poster,5));
        events.add(new Events("Digital Marketing Workshop",R.drawable.digital_marketing_workshop_poster,6));
        events.add(new Events("Biz Quiz",R.drawable.ecell_nitdgp,7));
        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);

        // Create adapter passing in the sample user data
        EventsRVAdapter adapter = new EventsRVAdapter(getApplicationContext(), events);

        // Set layout manager to position the items
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
