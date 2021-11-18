package me.jimmyberg.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBatchStarterApplication

fun main(args: Array<String>) {
    runApplication<SpringBatchStarterApplication>(*args)
}
