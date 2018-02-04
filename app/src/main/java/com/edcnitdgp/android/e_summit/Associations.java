package com.edcnitdgp.android.e_summit;

/**
 * Created by Dell on 31-Jan-18.
 */

public class Associations {

    private String mAssocName;
    private int mAssocNumber;
    private int mImageResourceId=0;

    public Associations(String AssocName, int ImageResourceId,int AssocNumber) {
        this.mAssocName = AssocName;
        this.mImageResourceId = ImageResourceId;
        this.mAssocNumber=AssocNumber;
    }

    public String getmAssocName() {
        return mAssocName;
    }

    public void setmAssocName(String mAssocName) {
        this.mAssocName = mAssocName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public int getmAssocNumber() {
        return mAssocNumber;
    }
}
