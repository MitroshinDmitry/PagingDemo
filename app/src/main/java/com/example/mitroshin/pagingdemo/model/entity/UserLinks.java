package com.example.mitroshin.pagingdemo.model.entity;

import com.google.gson.annotations.SerializedName;

public class UserLinks {

    @SerializedName("self")
    public final String self;

    @SerializedName("html")
    public final String html;

    @SerializedName("photos")
    public final String photos;

    @SerializedName("likes")
    public final String likes;

    @SerializedName("portfolio")
    public final String portfolio;

    public UserLinks(String self,
                     String html,
                     String photos,
                     String likes,
                     String portfolio) {
        this.self = self;
        this.html = html;
        this.photos = photos;
        this.likes = likes;
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "UserLinks{" +
                "self='" + self + '\'' +
                ", html='" + html + '\'' +
                ", photos='" + photos + '\'' +
                ", likes='" + likes + '\'' +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}
