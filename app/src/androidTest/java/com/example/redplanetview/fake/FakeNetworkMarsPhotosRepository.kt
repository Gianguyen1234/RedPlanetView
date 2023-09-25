package com.example.redplanetview.fake

import com.example.redplanetview.data.MarsPhotosRepository
import com.example.redplanetview.model.MarsPhotosData

class FakeNetworkMarsPhotosRepository: MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhotosData> {
        return FakeDataSource.photosList
    }
}