package com.example.movieapp.api

import retrofit2.Call
import com.example.movieapp.api.Login
import com.example.movieapp.api.Post
import com.example.movieapp.api.Token
import com.example.movieapp.api.Users
import retrofit2.http.*
const val api_key = "753b84576c954d96997803298a188f83"
interface UserClient {
    @POST("authentication/token/validate_with_login?api_key=753b84576c954d96997803298a188f83")
    fun login(@Body login:Login): Call<Token>

    @GET("authentication/token/new?api_key=753b84576c954d96997803298a188f83")
    fun getToken():Call<Token>

    @GET("posts")
    fun getPostList(): Call<List<Post>>
    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>
}