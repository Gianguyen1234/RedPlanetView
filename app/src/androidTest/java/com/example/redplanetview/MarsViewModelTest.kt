package com.example.redplanetview
import com.example.redplanetview.fake.FakeDataSource
import com.example.redplanetview.fake.FakeNetworkMarsPhotosRepository
import com.example.redplanetview.rules.TestDispatcherRule
import com.example.redplanetview.model.screens.MarsUiState
import com.example.redplanetview.model.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotosRepository = FakeNetworkMarsPhotosRepository()
            )
            assertEquals(
                MarsUiState.Success(FakeDataSource.photosList),
                marsViewModel.marsUiState
            )
        }
}
