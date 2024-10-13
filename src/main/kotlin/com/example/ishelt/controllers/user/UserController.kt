package com.example.ishelt.controllers.user

import com.example.ishelt.data.service.user.UserService
import com.example.ishelt.domain.models.user.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(
        private val userService: UserService,
) {
    @GetMapping("/users")
    fun getUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping("/create_user")
    fun createUser(
            @RequestBody name: String,
            @RequestBody email: String,
    ): UUID {
        return userService.createUser(name, email)
    }

    @PostMapping("/update_user")
    fun updateUser(
            @RequestBody name: String,
            @RequestBody newName: String?,
            @RequestBody email: String?,
    ): Boolean {
        return userService.updateUser(name, newName, email)
    }

    @PostMapping("/delete_user")
    fun deleteUser(@RequestBody name: String) {
        userService.deleteUserByName(name)
    }

    @GetMapping("/get_user")
    fun getUser(@RequestParam name: String): Optional<User> {
        return userService.getUserByName(name)
    }
}