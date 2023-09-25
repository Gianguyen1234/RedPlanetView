package com.example.redplanetview.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Create a data class that represents the response you expect from the API.
@Serializable
data class MarsPhotosData(
    val id: String,
    @SerialName("img_src")
    val imgSrc: String,
)