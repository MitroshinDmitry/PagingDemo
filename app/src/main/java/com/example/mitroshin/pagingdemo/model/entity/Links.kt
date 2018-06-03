package com.example.mitroshin.pagingdemo.model.entity

import com.google.gson.annotations.SerializedName

class Links(
        @field:SerializedName("self")
        val self: String,

        @field:SerializedName("html")
        val html: String,

        @field:SerializedName("download")
        val download: String,

        @field:SerializedName("download_location")
        val downloadLocation: String)