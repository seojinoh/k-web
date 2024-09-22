package com.example.kweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KWebApplication

fun main(args: Array<String>) {
    runApplication<KWebApplication>(*args)
}
