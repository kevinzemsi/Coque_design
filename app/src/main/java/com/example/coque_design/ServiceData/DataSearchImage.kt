package com.example.coque_design.ServiceData

data class DataSearchImage(
    val data : List<Image>,
    val alt: String,
    val avg_color: String,
    val height: Int,
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    val image: Image,
    val url: String,
    val width: Int
)