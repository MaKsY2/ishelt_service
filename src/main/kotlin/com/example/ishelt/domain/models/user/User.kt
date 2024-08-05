package com.example.ishelt.domain.models.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
open class User(
        @Id
        open var id: UUID,
        open var name: String,
        open var email: String
)