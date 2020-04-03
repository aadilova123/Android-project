package com.example.movieapp.api

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id") val postId: Int,
    @SerializedName("email") val userId: String,
    @SerializedName("token") val title: String
)