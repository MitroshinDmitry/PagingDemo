package com.example.mitroshin.pagingdemo.model.entity;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    public final String id;

    @SerializedName("created_at")
    public final String createdAt;

    @SerializedName("updated_at")
    public final String updatedAt;

    @SerializedName("width")
    public final int width;

    @SerializedName("height")
    public final int height;

    @SerializedName("color")
    public final String color;

    @SerializedName("likes")
    public final int likes;

    @SerializedName("liked_by_user")
    public final boolean likedByUser;

    @SerializedName("description")
    public final String description;

    @SerializedName("user")
    public final User user;

    @SerializedName("urls")
    public final Urls urls;

    @SerializedName("links")
    public final Links links;

    public Photo(String id,
                 String createdAt,
                 String updatedAt,
                 int width,
                 int height,
                 String color,
                 int likes,
                 boolean likedByUser,
                 String description,
                 User user,
                 Urls urls,
                 Links links) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.description = description;
        this.user = user;
        this.urls = urls;
        this.links = links;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", likes=" + likes +
                ", likedByUser=" + likedByUser +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", urls=" + urls +
                ", links=" + links +
                '}';
    }
}