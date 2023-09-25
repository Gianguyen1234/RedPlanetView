package com.example.redplanetview.data

import com.example.redplanetview.model.MarsPhotosData

import com.example.redplanetview.network.MarsApiService

interface MarsPhotosRepository{

    suspend fun getMarsPhotos(): List<MarsPhotosData>
}

/*
create a class named NetworkMarsPhotosRepository
for implementing the MarsPhotosRepository interface.
 */
class NetworkMarsPhotosRepository
    (private val marsApiService: MarsApiService
): MarsPhotosRepository{
    override suspend fun getMarsPhotos(): List<MarsPhotosData> = marsApiService.getPhotos()

}