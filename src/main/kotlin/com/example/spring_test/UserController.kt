package com.example.spring_test

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(val userRepository: UserRepository) {

    @GetMapping
    fun users(): Flux<User> {
        return userRepository.findAll()
    }

    @PostMapping
    fun newUser(@RequestBody user: User): Mono<User> {
        val newUser = userRepository.save(user)
        return newUser
    }
}