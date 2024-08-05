package com.example.ishelt.controllers.placemark

import com.example.ishelt.data.service.placemark.PlacemarkService
import com.example.ishelt.domain.models.placemark.Placemark
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PlacemarkController (
        private val placemarkService: PlacemarkService
) {
    @GetMapping("/placemarks")
    fun getPlacemarks(): List<Placemark> {
        return placemarkService.getAllPlacemarks()
    }

}