package com.edcnitdgp.android.e_summit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 29-Jan-18.
 */

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class TeamMembersRVAdapter extends
        RecyclerView.Adapter<TeamMembersRVAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView memberNameTextView;
        public TextView memberPostTextView;
        public ImageView memberImageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            memberNameTextView = itemView.findViewById(R.id.member_name);
            memberPostTextView=itemView.findViewById(R.id.member_post);
            memberImageView = itemView.findViewById(R.id.member_pic);
        }
    }
        private ArrayList<TeamMember> mMembers;
        // Store the context for easy access
        private Context mContext;

        // Pass in the contact array into the constructor
        public TeamMembersRVAdapter(Context context, ArrayList<TeamMember> members) {
            mMembers = members;
            mContext = context;
        }

        // Easy access to the context object in the recyclerview
        private Context getContext() {
            return mContext;
        }


        // Usually involves inflating a layout from XML and returning the holder
        @Override
        public TeamMembersRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.teammember_cardview_layout, parent, false);

            // Return a new holder instance
            return new ViewHolder(contactView);
        }

        // Involves populating data into the item through holder
        @Override
        public void onBindViewHolder(final TeamMembersRVAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
             final TeamMember member = mMembers.get(position);
            // Set item views based on your views and data model
            TextView memberName = viewHolder.memberNameTextView;
            memberName.setText(member.getmMemberName());
            TextView memberPost = viewHolder.memberPostTextView;
            memberPost.setText(member.getmMemberPost());
//            ImageView memberImage = viewHolder.memberImageView;
//            memberImage.setImageResource(member.getmImageResourceId());
            Glide.with(mContext).load(member.getmImageResourceId()).into(viewHolder.memberImageView);

        }
        // Returns the total count of items in the list
        @Override
        public int getItemCount() {
            return mMembers.size();
        }
    }

