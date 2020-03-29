package com.example.moviedbapi
import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("id") val id: Int? = null,
    @SerializedName("rating") val rating: Double? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null
    )
