package com.example.ishelt.domain.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "posts")
class Post(
        @Id
        val id: UUID,
        val userId: UUID,
        val title: String,
        val body: String,
        val imageUrl: String
)