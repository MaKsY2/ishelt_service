package com.example.ishelt.domain.models.placemark

import java.util.UUID
import jakarta.persistence.*
@Entity
@Table(name = "placemarks")
open class Placemark (
    @Id
    open var id: UUID,
    open var postId: UUID,
    open var lat: Double,
    open var lon: Double
)