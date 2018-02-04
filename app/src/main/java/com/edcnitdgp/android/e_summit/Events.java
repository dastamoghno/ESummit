package com.edcnitdgp.android.e_summit;

import java.util.ArrayList;

/**
 * Created by Dell on 26-Jan-18.
 */

public class Events {
    private String mEventName;
    private int mEventNumber;
    private int mImageResourceId=0;

    public Events(String EventName, int ImageResourceId,int EventNumber) {
        this.mEventName = EventName;
        this.mImageResourceId = ImageResourceId;
        this.mEventNumber=EventNumber;
    }

    public String getmEventName() {
        return mEventName;
    }

    public void setmEventName(String mEventName) {
        this.mEventName = mEventName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public int getmEventNumber() {
        return mEventNumber;
    }

}
