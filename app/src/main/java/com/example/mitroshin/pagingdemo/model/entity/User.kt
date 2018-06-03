package com.example.mitroshin.pagingdemo.model.entity

import com.google.gson.annotations.SerializedName

data class User(
        @field:SerializedName("id")
        val id: String,

        @field:SerializedName("username")
        val username: String,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("portfolio_url")
        val portfolioUrl: String,

        @field:SerializedName("bio")
        val bio: String,

        @field:SerializedName("location")
        val location: String,

        @field:SerializedName("total_likes")
        val totalLikes: Int,

        @field:SerializedName("total_photos")
        val totalPhotos: Int,

        @field:SerializedName("total_collections")
        val totalCollections: Int,

        @field:SerializedName("instagram_username")
        val instagramUsername: String,

        @field:SerializedName("twitter_username")
        val twitterUsername: String,

        @field:SerializedName("profile_image")
        val profileImage: ProfileImage,

        @field:SerializedName("links")
        val links: UserLinks)