package com.edcnitdgp.android.e_summit;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TeamMembersTabbedActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ourteam_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private int mTeamMemberNumber;
        public ImageView mTeamMemberImage;
        public TextView mTeamMemberName;
        public TextView mTeamMemberPost;
        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        /**
         * Called to do initial creation of a fragment.  This is called after
         * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
         * <p>
         * <p>Note that this can be called while the fragment's activity is
         * still in the process of being created.  As such, you can not rely
         * on things like the activity's content view hierarchy being initialized
         * at this point.  If you want to do work once the activity itself is
         * created, see {@link #onActivityCreated(Bundle)}.
         * <p>
         * <p>Any restored child fragments will be created before the base
         * <code>Fragment.onCreate</code> method returns.</p>
         *
         * @param savedInstanceState If the fragment is being re-created from
         *                           a previous saved state, this is the state.
         */
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mTeamMemberNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.ourteam_recycler_layout, container, false);
//            mTeamMemberImage=rootView.findViewById(R.id.member_pic);
//            mTeamMemberName=rootView.findViewById(R.id.member_name);
//            mTeamMemberPost=rootView.findViewById(R.id.member_post);
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rvContacts);


            // Set layout manager to position the items
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(rootView.getContext(), 2);
            recyclerView.setLayoutManager(mLayoutManager);
//            recyclerView.addItemDecoration(new TeamMembersTabbedActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            switch (mTeamMemberNumber)
            {
                case 1:final ArrayList<TeamMember> members1 = new ArrayList<TeamMember>();
                    members1.add(new TeamMember("Viswambher Kambhampati","President", R.drawable.auction_arcadia_poster,1));
                    members1.add(new TeamMember("Rajat Sirsikar","Convenor",R.drawable.ecell_nitdgp,2));
                    members1.add(new TeamMember("Susmita Maitra","Content Head",R.drawable.ecell_nitdgp,3));
                    members1.add(new TeamMember("Anupam Kashyap","Treasurer",R.drawable.e_talks1,4));
                    members1.add(new TeamMember("Abhishek Kaushik","General Secretary",R.drawable.entre_writeup_poster,5));
                    members1.add(new TeamMember("Prashant Prabhu","Technical Head",R.drawable.digital_marketing_workshop_poster,6));
                    // Create adapter passing in the sample user data
                    TeamMembersRVAdapter adapter1 = new TeamMembersRVAdapter(rootView.getContext(),members1);
                    // Attach the adapter to the recyclerview to populate items
                    recyclerView.setAdapter(adapter1);
                        break;
                case 2:final ArrayList<TeamMember> members2 = new ArrayList<TeamMember>();
                    members2.add(new TeamMember("Sahil Jain","Public Relations", R.drawable.auction_arcadia_poster,1));
                    members2.add(new TeamMember("Rajat Sirsikar","Convenor",R.drawable.ecell_nitdgp,2));
                    members2.add(new TeamMember("Susmita Maitra","Content Head",R.drawable.ecell_nitdgp,3));
                    members2.add(new TeamMember("Anupam Kashyap","Treasurer",R.drawable.e_talks1,4));
                    members2.add(new TeamMember("Abhishek Kaushik","General Secretary",R.drawable.entre_writeup_poster,5));
                    members2.add(new TeamMember("Prashant Prabhu","Technical Head",R.drawable.digital_marketing_workshop_poster,6));
                    // Create adapter passing in the sample user data
                    TeamMembersRVAdapter adapter2 = new TeamMembersRVAdapter(rootView.getContext(),members2);
                    // Attach the adapter to the recyclerview to populate items
                    recyclerView.setAdapter(adapter2);
                    break;
                case 3:final ArrayList<TeamMember> members3 = new ArrayList<TeamMember>();
                    members3.add(new TeamMember("Sounak Saha","President", R.drawable.auction_arcadia_poster,1));
                    members3.add(new TeamMember("Rajat Sirsikar","Convenor",R.drawable.ecell_nitdgp,2));
                    members3.add(new TeamMember("Susmita Maitra","Content Head",R.drawable.ecell_nitdgp,3));
                    members3.add(new TeamMember("Anupam Kashyap","Treasurer",R.drawable.e_talks1,4));
                    members3.add(new TeamMember("Abhishek Kaushik","General Secretary",R.drawable.entre_writeup_poster,5));
                    members3.add(new TeamMember("Prashant Prabhu","Technical Head",R.drawable.digital_marketing_workshop_poster,6));
                    // Create adapter passing in the sample user data
                    TeamMembersRVAdapter adapter3 = new TeamMembersRVAdapter(rootView.getContext(),members3);
                    // Attach the adapter to the recyclerview to populate items
                    recyclerView.setAdapter(adapter3);
                    break;
                case 4:final ArrayList<TeamMember> members = new ArrayList<TeamMember>();
                    members.add(new TeamMember("Swarnendu Mondal","President", R.drawable.auction_arcadia_poster,1));
                    members.add(new TeamMember("Rajat Sirsikar","Convenor",R.drawable.ecell_nitdgp,2));
                    members.add(new TeamMember("Susmita Maitra","Content Head",R.drawable.ecell_nitdgp,3));
                    members.add(new TeamMember("Anupam Kashyap","Treasurer",R.drawable.e_talks1,4));
                    members.add(new TeamMember("Abhishek Kaushik","General Secretary",R.drawable.entre_writeup_poster,5));
                    members.add(new TeamMember("Prashant Prabhu","Technical Head",R.drawable.digital_marketing_workshop_poster,6));
                    // Create adapter passing in the sample user data
                    TeamMembersRVAdapter adapter = new TeamMembersRVAdapter(rootView.getContext(),members);
                    // Attach the adapter to the recyclerview to populate items
                    recyclerView.setAdapter(adapter);
                    break;
            }

            return rootView;
        }

        /**
         * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
         * has returned, but before any saved state has been restored in to the view.
         * This gives subclasses a chance to initialize themselves once
         * they know their view hierarchy has been completely created.  The fragment's
         * view hierarchy is not however attached to its parent at this point.
         *
         * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
         * @param savedInstanceState If non-null, this fragment is being re-constructed
         */
        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.rvContacts);
            TeamMembersRVAdapter adapter = new TeamMembersRVAdapter(view.getContext(),new ArrayList<TeamMember>());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 4;
        }
    }


/**
 * RecyclerView item decoration - give equal margin around grid item
 */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;
    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

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
}

