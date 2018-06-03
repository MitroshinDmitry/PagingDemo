package com.example.mitroshin.pagingdemo.model.entity

import com.google.gson.annotations.SerializedName

class Photo(
        @field:SerializedName("id")
        val id: String,

        @field:SerializedName("created_at")
        val createdAt: String,

        @field:SerializedName("updated_at")
        val updatedAt: String,

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int,

        @field:SerializedName("color")
        val color: String,

        @field:SerializedName("likes")
        val likes: Int,

        @field:SerializedName("liked_by_user")
        val likedByUser: Boolean,

        @field:SerializedName("description")
        val description: String,

        @field:SerializedName("user")
        val user: User,

        @field:SerializedName("urls")
        val urls: Urls,

        @field:SerializedName("links")
        val links: Links)