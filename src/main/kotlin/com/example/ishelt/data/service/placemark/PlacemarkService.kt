package com.example.ishelt.data.service.placemark

import com.example.ishelt.domain.models.placemark.Placemark
import com.example.ishelt.domain.repository.placemark.PlacemarkRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlacemarkService(
        private val placemarkRepository: PlacemarkRepository,
) {
    fun createPlacemark(lat: Double, lon: Double, postId: UUID): UUID {
        val newUID = UUID.randomUUID()
        val newPlacemark = Placemark(id = newUID, lat = lat, lon = lon, postId = postId)
        placemarkRepository.save(newPlacemark)
        return newUID
    }

    fun deletePlacemark(postId: UUID) {
        placemarkRepository.deleteByPostId(postId)
    }

    fun getAllPlacemarks(): List<Placemark> = placemarkRepository.findAll().toList()
}