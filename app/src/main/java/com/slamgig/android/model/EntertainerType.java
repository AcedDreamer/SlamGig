package com.slamgig.android.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adaobifrank on 8/16/17.
 */

public class EntertainerType implements Parcelable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public EntertainerType(String name){
        this.name = name;
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
}
