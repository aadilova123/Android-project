package com.example.moviedbapi
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Post(

    @SerializedName("id") val movieId: Int,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("title") val title: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val description : String,
    @SerializedName("vote_average") val rating : Double,
    @SerializedName("release_date") val releaseDate : LocalDate
    )
