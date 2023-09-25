package com.example.redplanetview.model.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.redplanetview.R
import com.example.redplanetview.model.MarsPhotosData
import com.example.redplanetview.ui.theme.RedPlanetViewTheme

@Composable
fun HomeScreen(
    marsUiState: MarsUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (marsUiState) {
        is MarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is MarsUiState.Success -> PhotosGridScreen(photos = marsUiState.photos, modifier = modifier)
        is MarsUiState.Error -> ErrorScreen( retryAction ,modifier = modifier.fillMaxSize())
    }
}



@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading),
        contentDescription = "Loading"
    )
}

@Composable
fun ErrorScreen(retryAction: ()-> Unit,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
        Text(text = "Error now", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(text = "Retry", style = MaterialTheme.typography.bodySmall)
        }
    }
}


/*@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos)
    }
}*/

@Composable
fun MarsPhotosCard(photo: MarsPhotosData, modifier: Modifier = Modifier){

    Card(modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest
                .Builder(context = LocalContext.current)
                .data(photo.imgSrc)
                .crossfade(true)
                .build(),
            error = painterResource(id = R.drawable.error),
            placeholder = painterResource(id = R.drawable.loading),
            contentDescription = stringResource(id = R.string.mars_photo),
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()

        )
    }
    
}

@Composable
fun PhotosGridScreen(photos: List<MarsPhotosData>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
        ){
        items(items = photos, key = {photo -> photo.id}){
            photo -> MarsPhotosCard(photo = photo,
            modifier = modifier
                .padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(5.dp))

            )
        }

    }
}
@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    RedPlanetViewTheme {
        val mockData = List(10) { MarsPhotosData("$it", "") }
        PhotosGridScreen(mockData)
    }
}
@Preview(showBackground = true)
@Composable
fun ErrorScreen() {
    RedPlanetViewTheme {
       ErrorScreen({  })
    }
}





