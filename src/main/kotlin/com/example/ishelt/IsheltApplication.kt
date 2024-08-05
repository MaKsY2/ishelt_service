package com.example.ishelt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class IsheltApplication

fun main(args: Array<String>) {
    runApplication<IsheltApplication>(*args)
}
