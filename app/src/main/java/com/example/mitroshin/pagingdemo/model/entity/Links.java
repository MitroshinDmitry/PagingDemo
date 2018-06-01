package com.example.mitroshin.pagingdemo.model.entity;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    public final String self;

    @SerializedName("html")
    public final String html;

    @SerializedName("download")
    public final String download;

    @SerializedName("download_location")
    public final String downloadLocation;

    public Links(String self,
                 String html,
                 String download,
                 String downloadLocation) {
        this.self = self;
        this.html = html;
        this.download = download;
        this.downloadLocation = downloadLocation;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self='" + self + '\'' +
                ", html='" + html + '\'' +
                ", download='" + download + '\'' +
                ", downloadLocation='" + downloadLocation + '\'' +
                '}';
    }
}