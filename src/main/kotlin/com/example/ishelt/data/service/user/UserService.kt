package com.example.ishelt.data.service.user

import com.example.ishelt.domain.models.user.User
import com.example.ishelt.domain.repository.user.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun getUserByName(name: String): Optional<User> = userRepository.findUserByName(name)
    fun getUserById(id: UUID): Optional<User> = userRepository.findUserById(id)

    fun updateUser(name: String, newName: String?, email: String?): Boolean {
        if (newName == null && email == null) {
            return false
        }
        val oldUser = userRepository.findUserByName(name)
        if (oldUser.isPresent) {
            val newUser = User(
                    id = oldUser.get().id,
                    name = newName ?: oldUser.get().name,
                    email = email ?: oldUser.get().email
            )
            userRepository.save(newUser)
            return true
        }
        return false
    }

    fun deleteUserByName(name: String) {
        val user = userRepository.findUserByName(name)
        if (user.isPresent) {
            userRepository.delete(user.get())
        }
    }

    fun getAllUsers(): List<User> = userRepository.findAll().toList()

    fun createUser(name: String, email: String): UUID {
        val oldUser = userRepository.findUserByName(name)
        if (oldUser.isPresent) {
            return oldUser.get().id
        }
        val newUID = UUID.randomUUID()
        val newUser = User(id = newUID, name = name, email = email)
        userRepository.save(newUser)
        return newUID
    }

}