package com.slamgig.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.mycardboarddreams.autocompletebubbletext.MultiSelectItem;

/**
 * Created by adaobifrank on 8/16/17.
 */

public class EntertainerType implements MultiSelectItem,Parcelable {

    String mId;
    String name;

    public EntertainerType(String name){
        this.name = name;
        this.mId = String.valueOf(name.hashCode());
    }
    protected EntertainerType(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<EntertainerType> CREATOR = new Creator<EntertainerType>() {
        @Override
        public EntertainerType createFromParcel(Parcel in) {
            return new EntertainerType(in);
        }

        @Override
        public EntertainerType[] newArray(int size) {
            return new EntertainerType[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }

    @Override
    public String getId() {
        return this.mId;
    }

    @Override
    public String getReadableName() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
