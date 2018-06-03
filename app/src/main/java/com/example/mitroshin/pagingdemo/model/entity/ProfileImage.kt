package com.example.mitroshin.pagingdemo.model.entity

import com.google.gson.annotations.SerializedName

class ProfileImage(
        @field:SerializedName("small")
        val small: String,

        @field:SerializedName("medium")
        val medium: String,

        @field:SerializedName("large")
        val large: String)
