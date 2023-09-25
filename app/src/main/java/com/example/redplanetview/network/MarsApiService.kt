package com.example.redplanetview.network

import com.example.redplanetview.model.MarsPhotosData
import retrofit2.http.GET


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhotosData>
}

