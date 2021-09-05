package com.example.racketapp.network


import com.example.racketapp.data.RocketDataItem

import retrofit2.http.GET

interface RetroService {

    companion object{

        val BASE_URL = "https://api.spacexdata.com/v4/"
    }

    @GET("Rockets")
    suspend fun getRocketApi(): List<RocketDataItem>
}