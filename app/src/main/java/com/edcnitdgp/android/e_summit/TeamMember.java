package com.edcnitdgp.android.e_summit;

/**
 * Created by Dell on 03-Feb-18.
 */

public class TeamMember {
    private String mMemberName;
    private String mMemberPost;
    private int mImageResourceId=0;
    private int mMemberNumber;

    public TeamMember(String mMemberName, String mMemberPost, int mImageResourceId, int mMemberNumber) {
        this.mMemberName = mMemberName;
        this.mMemberPost = mMemberPost;
        this.mImageResourceId = mImageResourceId;
        this.mMemberNumber = mMemberNumber;
    }

    public String getmMemberPost() {
        return mMemberPost;
    }

    public String getmMemberName() {
        return mMemberName;
    }

    public int getmMemberNumber() {
        return mMemberNumber;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
