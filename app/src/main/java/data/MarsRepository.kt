package com.example.android_internet.data

interface MarsRepository {

    suspend fun getMarsPhotos(): List<MarsPhoto>

}