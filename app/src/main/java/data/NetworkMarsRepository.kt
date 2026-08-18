package com.example.android_internet.data

import com.example.android_internet.network.MarsApiService

class NetworkMarsRepository(
    private val marsApiService: MarsApiService
) : MarsRepository {

    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }

}