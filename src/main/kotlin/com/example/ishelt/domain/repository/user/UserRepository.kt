package com.example.ishelt.domain.repository.user

import org.springframework.data.repository.CrudRepository
import com.example.ishelt.domain.models.user.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {
    fun findUserById(id: UUID): Optional<User>
    fun findUserByName(name: String): Optional<User>
}