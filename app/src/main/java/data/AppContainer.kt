package com.example.android_internet.data

import com.example.android_internet.network.MarsApi

interface AppContainer {

    val marsRepository: MarsRepository

}
class DefaultAppContainer : AppContainer {

    override val marsRepository: MarsRepository by lazy {

        NetworkMarsRepository(
            MarsApi.retrofitService
        )

    }

}