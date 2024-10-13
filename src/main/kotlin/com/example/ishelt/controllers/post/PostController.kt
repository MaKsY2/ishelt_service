package com.example.ishelt.controllers.post

import com.example.ishelt.data.service.post.PostService
import com.example.ishelt.data.service.post.dto.CreatePostDto
import com.example.ishelt.domain.models.post.Post
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class PostController(
        private val postService: PostService,
) {
    @GetMapping("/post/all/except")
    fun getAllPostsExceptUser(@RequestParam userId: UUID): List<Post> {
        return postService.getAllPostsExceptUser(userId)
    }

    @GetMapping("/post")
    fun getPostById(@RequestParam id: UUID): Optional<Post> {
        return postService.getPostById(id)
    }

    @GetMapping("/posts")
    fun getPosts(): List<Post> {
        return postService.getAllPosts()
    }

    @GetMapping("/posts/user")
    fun getPostsByUser(@RequestParam userId: UUID): List<Post> {
        return postService.getUserPosts(userId)
    }

    @GetMapping("/posts/all")
    fun getAllPosts(@RequestParam userId: UUID): List<Post> {
        return postService.getAllPosts()
    }

    @PostMapping("/posts/create")
    fun createPost(@RequestBody post: CreatePostDto): UUID {
        return postService.createPost(post)
    }

    @PostMapping("/posts/delete")
    fun deletePost(@RequestBody id: UUID) {
        postService.deletePost(id)
    }


}
