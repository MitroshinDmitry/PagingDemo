package com.example.mitroshin.pagingdemo.model.entity;

import com.google.gson.annotations.SerializedName;

public class ProfileImage {

    @SerializedName("small")
    public final String small;

    @SerializedName("medium")
    public final String medium;

    @SerializedName("large")
    public final String large;

    public ProfileImage(String small,
                        String medium,
                        String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    @Override
    public String toString() {
        return "ProfileImage{" +
                "small='" + small + '\'' +
                ", medium='" + medium + '\'' +
                ", large='" + large + '\'' +
                '}';
    }
}
