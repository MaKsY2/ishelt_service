package com.example.ishelt.domain.models

import java.util.UUID
import jakarta.persistence.*
@Entity
@Table(name = "placemarks")
data class Placemark (
    @Id
    val id: UUID,
    val postId: UUID,
    val lat: Double,
    val lon: Double
)