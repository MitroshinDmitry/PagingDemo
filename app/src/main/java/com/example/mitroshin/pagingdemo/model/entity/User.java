package com.example.mitroshin.pagingdemo.model.entity;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    public final String id;

    @SerializedName("username")
    public final String username;

    @SerializedName("name")
    public final String name;

    @SerializedName("portfolio_url")
    public final String portfolioUrl;

    @SerializedName("bio")
    public final String bio;

    @SerializedName("location")
    public final String location;

    @SerializedName("total_likes")
    public final int totalLikes;

    @SerializedName("total_photos")
    public final int totalPhotos;

    @SerializedName("total_collections")
    public final int totalCollections;

    @SerializedName("instagram_username")
    public final String instagramUsername;

    @SerializedName("twitter_username")
    public final String twitterUsername;

    @SerializedName("profile_image")
    public final ProfileImage profileImage;

    @SerializedName("links")
    public final UserLinks links;

    public User(String id,
                String username,
                String name,
                String portfolioUrl,
                String bio,
                String location,
                int totalLikes,
                int totalPhotos,
                int totalCollections,
                String instagramUsername,
                String twitterUsername,
                ProfileImage profileImage,
                UserLinks links) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.totalCollections = totalCollections;
        this.instagramUsername = instagramUsername;
        this.twitterUsername = twitterUsername;
        this.profileImage = profileImage;
        this.links = links;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", portfolioUrl='" + portfolioUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", location='" + location + '\'' +
                ", totalLikes=" + totalLikes +
                ", totalPhotos=" + totalPhotos +
                ", totalCollections=" + totalCollections +
                ", instagramUsername='" + instagramUsername + '\'' +
                ", twitterUsername='" + twitterUsername + '\'' +
                ", profileImage=" + profileImage +
                ", links=" + links +
                '}';
    }
}