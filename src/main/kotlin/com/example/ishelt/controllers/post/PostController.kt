package com.example.ishelt.controllers.post

import com.example.ishelt.data.service.post.PostService
import com.example.ishelt.data.service.post.dto.CreatePostDto
import com.example.ishelt.domain.models.post.Post
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class PostController(
        private val postService: PostService,
) {
    @GetMapping("/post/all/except")
    fun getAllPostsExceptUser(userId: UUID): List<Post> {
        return postService.getAllPostsExceptUser(userId)
    }

    @GetMapping("/post")
    fun getPostById(id: UUID): Optional<Post> {
        return postService.getPostById(id)
    }

    @GetMapping("/posts")
    fun getPosts(): List<Post> {
        return postService.getAllPosts()
    }

    @GetMapping("/posts/user")
    fun getPostsByUser(userId: UUID): List<Post> {
        return postService.getUserPosts(userId)
    }

    @GetMapping("/posts/all")
    fun getAllPosts(userId: UUID): List<Post> {
        return postService.getAllPosts()
    }

    @PostMapping("/posts/create")
    fun createPost(dto: CreatePostDto): UUID {
        return postService.createPost(dto)
    }

    @PostMapping("/posts/delete")
    fun deletePost(id: UUID) {
        postService.deletePost(id)
    }


}
