package com.example.cinea.main.data.remote.api

import com.example.cinea.Configuration
import com.example.cinea.Configuration.API_KEY
import com.example.cinea.main.data.remote.dto.MediaListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MediaApi {

    @GET("trending/{type}/{time}")
    suspend fun getPopularMovies(
        @Path("type") type: String,
        @Path("time") time: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ): MediaListDto?

    @GET("{type}/{category}")
    suspend fun getMoviesAndTv(
        @Path("type") type: String,
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ): MediaListDto?

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = Configuration.API_KEY
    }

}