package com.example.ishelt.domain.repository.post

import com.example.ishelt.domain.models.post.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostRepository : CrudRepository<Post, UUID> {

    fun findPostById(id: UUID): Optional<Post>

    fun findPostByUserId(userId: UUID): List<Post>

    fun findAllByUserId(id: UUID): List<Post>

    fun findPostsByUserIdNot(id: UUID): List<Post>

}