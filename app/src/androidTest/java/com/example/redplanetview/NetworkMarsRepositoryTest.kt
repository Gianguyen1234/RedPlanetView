package com.example.redplanetview

import com.example.redplanetview.data.NetworkMarsPhotosRepository
import com.example.redplanetview.fake.FakeDataSource
import com.example.redplanetview.fake.FakeMarsApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
        runTest {
            val repository = NetworkMarsPhotosRepository(
                marsApiService = FakeMarsApiService()
            )
            assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
        }
}