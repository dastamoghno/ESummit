package com.edcnitdgp.android.e_summit;

import android.content.Context;
import android.content.Intent;
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
public class EventsRVAdapter extends
        RecyclerView.Adapter<EventsRVAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView eventNameTextView;
        public ImageView eventIconImageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            eventNameTextView = itemView.findViewById(R.id.event_title);
            eventIconImageView = itemView.findViewById(R.id.event_logo);
        }
    }
        private ArrayList<Events> mEvents;
        // Store the context for easy access
        private Context mContext;

        // Pass in the contact array into the constructor
        public EventsRVAdapter( Context context,ArrayList<Events> events) {
            mEvents = events;
            mContext = context;
        }

        // Easy access to the context object in the recyclerview
        private Context getContext() {
            return mContext;
        }

        // Usually involves inflating a layout from XML and returning the holder
        @Override
        public EventsRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.event_cardview_layout, parent, false);

            // Return a new holder instance
            return new ViewHolder(contactView);
        }

        // Involves populating data into the item through holder
        @Override
        public void onBindViewHolder(final EventsRVAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
             final Events event = mEvents.get(position);
            // Set item views based on your views and data model
            TextView textView = viewHolder.eventNameTextView;
            textView.setText(event.getmEventName());
//            ImageView imageView = viewHolder.eventIconImageView;
//            imageView.setImageResource(event.getmImageResourceId());
            // loading album cover using Glide library
            Glide.with(mContext).load(event.getmImageResourceId()).into(viewHolder.eventIconImageView);

            viewHolder.eventIconImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int eventNo=event.getmEventNumber();
                    switch(eventNo)
                    {
                        case 1:Intent event1Intent=new Intent(view.getContext(),AuctionArcadiaActivity.class);
                            view.getContext().startActivity(event1Intent);
                            break;
                        case 2:Intent event2Intent=new Intent(view.getContext(),StartupWorkshopActivity.class);
                            view.getContext().startActivity(event2Intent);
                            break;
                        case 3:Intent event3Intent=new Intent(view.getContext(),PanelDiscussionActivity.class);
                            view.getContext().startActivity(event3Intent);
                            break;
                        case 4:Intent event4Intent=new Intent(view.getContext(),TabbedActivity.class);
                            view.getContext().startActivity(event4Intent);
                            break;
                        case 5:Intent event5Intent=new Intent(view.getContext(),EntreWriteupActivity.class);
                            view.getContext().startActivity(event5Intent);
                            break;
                        case 6:Intent event6Intent=new Intent(view.getContext(),DigitalMarketingWorkshopActivity.class);
                            view.getContext().startActivity(event6Intent);
                            break;
                        case 7:Intent event7Intent=new Intent(view.getContext(),BizQuizActivity.class);
                            view.getContext().startActivity(event7Intent);
                            break;
                }
            }
        });
        }
        // Returns the total count of items in the list
        @Override
        public int getItemCount() {
            return mEvents.size();
        }
    }

