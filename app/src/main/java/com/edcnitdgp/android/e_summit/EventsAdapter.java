package com.edcnitdgp.android.e_summit;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 26-Jan-18.
 */

public class EventsAdapter extends ArrayAdapter<Events> {
    public EventsAdapter(Activity context, ArrayList<Events> events) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, events);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item_layout, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Events currentEvent = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView eventNameTextView = (TextView) listItemView.findViewById(R.id.event_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        eventNameTextView.setText(currentEvent.getmEventName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.event_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
           iconView.setImageResource(currentEvent.getmImageResourceId());

//        View textContainer=listItemView.findViewById(R.id.text_container);
//        int color= ContextCompat.getColor(getContext(),mColorResourceId);
//        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

