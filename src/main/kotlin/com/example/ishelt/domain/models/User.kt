package com.example.ishelt.domain.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
class User(
        @Id
        val id: UUID,
        val name: String,
        val email: String
)