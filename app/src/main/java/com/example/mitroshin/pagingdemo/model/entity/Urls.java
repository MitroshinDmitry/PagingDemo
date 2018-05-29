package com.example.mitroshin.pagingdemo.model.entity;

import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("raw")
    public final String raw;

    @SerializedName("full")
    public final String full;

    @SerializedName("regular")
    public final String regular;

    @SerializedName("small")
    public final String small;

    @SerializedName("thumb")
    public final String thumb;

    public Urls(String raw,
                String full,
                String regular,
                String small,
                String thumb) {
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "Urls{" +
                "raw='" + raw + '\'' +
                ", full='" + full + '\'' +
                ", regular='" + regular + '\'' +
                ", small='" + small + '\'' +
                ", thumb='" + thumb + '\'' +
                '}';
    }
}