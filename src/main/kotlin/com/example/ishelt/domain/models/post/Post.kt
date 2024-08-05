package com.example.ishelt.domain.models.post

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "posts")
open class Post(
        @Id
        open var id: UUID,
        open var userId: UUID,
        open var title: String,
        open var body: String,
        open var imageUrl: String?
)