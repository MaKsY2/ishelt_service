package com.example.ishelt.data.service.placemark.dto

import java.util.*

data class CreatePlacemarkDto(
        val lat: Double,
        val lon: Double,
        val postId: UUID,
)