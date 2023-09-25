package com.example.redplanetview.fake

import com.example.redplanetview.model.MarsPhotosData

/*
In this object, create a property set to a list of MarsPhotosData objects.
 The list does not have to be long, but it should contain at least two objects.
 */
object FakeDataSource {

    private const val idOne = "img1"
    private const val idTwo = "img2"
    private const val imgOne = "url.1"
    private const val imgTwo = "url.2"
    val photosList = listOf(
        MarsPhotosData(
            id = idOne,
            imgSrc = imgOne
        ),
        MarsPhotosData(
            id = idTwo,
            imgSrc = imgTwo
        )
    )

}