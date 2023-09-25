package com.example.redplanetview.fake

import com.example.redplanetview.model.MarsPhotosData
import com.example.redplanetview.network.MarsApiService

class FakeMarsApiService: MarsApiService {
    override suspend fun getPhotos(): List<MarsPhotosData> {
        return FakeDataSource.photosList
    }
}