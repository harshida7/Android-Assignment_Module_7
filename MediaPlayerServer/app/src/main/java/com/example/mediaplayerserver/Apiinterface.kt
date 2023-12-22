package com.example.mediaplayerserver

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface
{

    @GET("song_view.php")
    fun categoryviewdata(): Call<List<Model>>
}
