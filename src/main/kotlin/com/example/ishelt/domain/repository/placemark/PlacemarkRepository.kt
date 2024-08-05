package com.example.ishelt.domain.repository.placemark

import com.example.ishelt.domain.models.placemark.Placemark
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlacemarkRepository : CrudRepository<Placemark, UUID> {
    fun deleteByPostId(postId: UUID)
    fun findPlacemarkByPostId(postId: UUID): Optional<Placemark>
}