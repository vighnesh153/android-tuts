package com.example.allaboutviews.network

import com.example.allaboutviews.domain.MyComment
import com.example.allaboutviews.domain.MyPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

// Json string to Kotlin object mapper
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    // json serializer/deserializer
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface JsonPlaceholderApiService {
    @GET("comments")
    suspend fun getComments(): List<MyComment>

    @GET("photos")
    suspend fun getPhotos(): List<MyPhoto>
}

object JsonPlaceholderApi {
    val jsonPlaceholderApiService: JsonPlaceholderApiService by lazy {
        retrofit.create(JsonPlaceholderApiService::class.java)
    }
}
