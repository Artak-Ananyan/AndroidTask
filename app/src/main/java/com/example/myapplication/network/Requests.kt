package com.example.myapplication.network

import retrofit2.Response
import retrofit2.http.GET

interface Requests {

    @GET("/getWells")
    suspend fun wellsItemsList(): Response<WellsitemsList>

}