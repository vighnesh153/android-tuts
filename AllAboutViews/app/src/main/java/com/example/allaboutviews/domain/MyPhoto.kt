package com.example.allaboutviews.domain

data class MyPhoto(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)