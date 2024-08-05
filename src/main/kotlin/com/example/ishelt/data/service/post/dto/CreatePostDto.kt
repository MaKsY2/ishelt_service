package com.example.ishelt.data.service.post.dto

import com.example.ishelt.data.service.placemark.dto.CreatePlacemarkDto
import java.util.*

data class CreatePostDto(
        val title: String,
        val body: String,
        val imageUrl: String?,
        val userId: UUID,
        val placemark: CreatePlacemarkDto,
)