package com.edcnitdgp.android.e_summit;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Dell on 31-Jan-18.
 */

public class AssociationsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_list_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Associations> assocs = new ArrayList<Associations>();
        assocs.add(new Associations("Auction Arcadia",R.drawable.auction_arcadia_poster,1));
        assocs.add(new Associations("Startup Workshop-Alley",R.drawable.ecell_nitdgp,2));
        assocs.add(new Associations("Panel Discussion",R.drawable.ecell_nitdgp,3));
        assocs.add(new Associations ("E-Talks",R.drawable.e_talks1,4));
        assocs.add(new Associations("Entre-writeup",R.drawable.entre_writeup_poster,5));
        assocs.add(new Associations("Digital Marketing Workshop",R.drawable.digital_marketing_workshop_poster,6));


//        // That's all!
        AssociationsAdapter assocsAdapter = new AssociationsAdapter(this, assocs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(assocsAdapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Associations assoc = assocs.get(i);
                int assocNo=assoc.getmAssocNumber();
                switch(assocNo)
                {
                    case 1:Intent event1Intent=new Intent(view.getContext(),AuctionArcadiaActivity.class);
                           startActivity(event1Intent);
                            break;
                    case 2:Intent event2Intent=new Intent(view.getContext(),AuctionArcadiaActivity.class);
                        startActivity(event2Intent);
                        break;
                    case 3:Intent event3Intent=new Intent(view.getContext(),TabbedActivity.class);
                        startActivity(event3Intent);
                        break;
                    case 4:Intent event4Intent=new Intent(view.getContext(),TabbedActivity.class);
                        startActivity(event4Intent);
                        break;
                    case 5:Intent event5Intent=new Intent(view.getContext(),TabbedActivity.class);
                        startActivity(event5Intent);
                        break;
                    case 6:Intent event6Intent=new Intent(view.getContext(),TabbedActivity.class);
                        startActivity(event6Intent);
                        break;

                }

            }
       });
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


