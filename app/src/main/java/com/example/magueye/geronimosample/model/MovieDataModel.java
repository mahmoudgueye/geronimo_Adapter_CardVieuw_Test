package com.example.magueye.geronimosample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by magueye on 13/01/2018.
 */

public class MovieDataModel implements Parcelable{

    private String name; //title
    private int details; //detail (ipsum...)
    private String category; //category of the movie
    private String imageURL; //link to a image of the


    public String getName() {
        return name;
    }

    public String getImage() {
        return imageURL;
    }

    public void setImage(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDetails() {
        return details;
    }

    public void setDetails(int details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MovieDataModel(){}

    public MovieDataModel(String name, int details, String category, String image){
        this.name = name;
        this.details = details;
        this.category = category;
        this.imageURL = image;
    }

    public MovieDataModel(Parcel prc) {
        this.name = prc.readString();
        this.details = prc.readInt();
        this.category = prc.readString();
        this.imageURL = prc.readString();
    }

    //instance of movie with a parcel
    public static final Creator<MovieDataModel> CREATOR = new Creator<MovieDataModel>() {
        public MovieDataModel createFromParcel(Parcel source) {
            return new MovieDataModel(source);
        }

        public MovieDataModel[]newArray(int size) {
            return new MovieDataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.details);
        parcel.writeString(this.category);
        parcel.writeString(this.imageURL);
    }

}
