package com.example.ishelt.data.service.post

import com.example.ishelt.data.service.placemark.PlacemarkService
import com.example.ishelt.data.service.post.dto.CreatePostDto
import com.example.ishelt.domain.models.post.Post
import com.example.ishelt.domain.repository.placemark.PlacemarkRepository
import com.example.ishelt.domain.repository.post.PostRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService(
        private val placemarkService: PlacemarkService,
        private val postRepository: PostRepository,
) {

    fun getUserPosts(id: UUID): List<Post> = postRepository.findAllByUserId(id)

    fun createPost(dto: CreatePostDto): UUID {
        val newUID = UUID.randomUUID()
        val newPost = Post(
                id = newUID,
                title = dto.title,
                body = dto.body,
                imageUrl = dto.imageUrl,
                userId = dto.userId,
        )
        postRepository.save(newPost)
        placemarkService.createPlacemark(lat = dto.placemark.lat, lon = dto.placemark.lon, postId = newUID)
        return newUID
    }

    fun getAllPosts(): List<Post> = postRepository.findAll().toList()

    fun deletePost(id: UUID) {
        postRepository.deleteById(id)
    }

    fun getAllPostsExceptUser(userId: UUID): List<Post> = postRepository.findPostsByUserIdNot(userId)

    fun getPostById(id: UUID): Optional<Post> = postRepository.findById(id)
}