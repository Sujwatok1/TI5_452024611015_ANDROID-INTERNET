package com.example.android_internet.data

import com.squareup.moshi.Json

data class MarsPhoto(

    val id: String,

    @Json(name = "img_src")
    val imgSrc: String

)