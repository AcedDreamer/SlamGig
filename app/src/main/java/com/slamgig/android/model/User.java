package com.slamgig.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by adaobifrank on 8/4/17.
 */

public class User implements Parcelable {

    public String key;
    public String email;
    public String firstname;
    public String lastname;
    public String username;
    public String avatar;
    public String bio;
    public List<String> userTypes;
    public List<String> entertainerTypes;
    public List<String> reviews;
    public String rating;

    public User(String key,String email){
        this.key = key;
        this.email = email;
    }

    public User(String id, String email,String firstname, String lastname, String username, String avatar, String bio,
                List<String> userTypes, List<String> entertainerTypes, List<String> reviews, String rating){
        this.key = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.avatar = avatar;
        this.bio = bio;
        this.userTypes = userTypes;
        this.entertainerTypes = entertainerTypes;
        this.reviews = reviews;
        this.rating = rating;
    }

    protected User(Parcel in) {
        key = in.readString();
        email = in.readString();
        firstname = in.readString();
        lastname = in.readString();
        username = in.readString();
        avatar = in.readString();
        bio = in.readString();
        userTypes = in.readArrayList(List.class.getClassLoader());
        entertainerTypes = in.readArrayList(List.class.getClassLoader());
        reviews = in.readArrayList(List.class.getClassLoader());
        rating = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeString(email);
        parcel.writeString(firstname);
        parcel.writeString(lastname);
        parcel.writeString(username);
        parcel.writeString(avatar);
        parcel.writeString(bio);
        parcel.writeList(userTypes);
        parcel.writeList(entertainerTypes);
        parcel.writeList(reviews);
        parcel.writeString(rating);
    }
}
