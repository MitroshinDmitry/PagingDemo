package com.example.mitroshin.pagingdemo.model.entity

import com.google.gson.annotations.SerializedName

data class UserLinks(
        @field:SerializedName("self")
        val self: String,

        @field:SerializedName("html")
        val html: String,

        @field:SerializedName("photos")
        val photos: String,

        @field:SerializedName("likes")
        val likes: String,

        @field:SerializedName("portfolio")
        val portfolio: String)
