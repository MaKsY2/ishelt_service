package com.example.ishelt.domain.repository

import org.springframework.data.repository.CrudRepository
import com.example.ishelt.domain.models.User
import java.util.*

interface UserRepository : CrudRepository<User, UUID> {
    fun findUserById(id: UUID): Optional<User>
    fun findUserByName(name: String): Optional<User>
}