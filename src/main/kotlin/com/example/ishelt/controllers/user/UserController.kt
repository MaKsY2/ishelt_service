package com.example.ishelt.controllers.user

import com.example.ishelt.data.service.user.UserService
import com.example.ishelt.domain.models.user.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(
        private val userService: UserService
) {
    @GetMapping("/users")
    fun getUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping("/createUser")
    fun createUser(
            @RequestParam name: String,
            @RequestParam email: String
    ): UUID {
        return userService.createUser(name, email)
    }

    @PostMapping("/updateUser")
    fun updateUser(
            @RequestParam name: String,
            @RequestParam newName: String?,
            @RequestParam email: String?
    ): Boolean {
        return userService.updateUser(name, newName, email)
    }

    @PostMapping("/deleteUser")
    fun deleteUser(name: String) {
        userService.deleteUserByName(name)
    }

    @GetMapping("/getUser")
    fun getUser(name: String): Optional<User> {
        return userService.getUserByName(name)
    }
}