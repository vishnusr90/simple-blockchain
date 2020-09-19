package com.demo.blockchain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleBlockchainApplication

fun main(args: Array<String>) {
    runApplication<SimpleBlockchainApplication>(*args)
}
