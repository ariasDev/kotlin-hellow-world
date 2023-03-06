package com.example.hellowworldkotlin.controller


import com.example.hellowworldkotlin.domain.User
import com.example.hellowworldkotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Long): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            ResponseEntity(user.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    fun addUser(@RequestBody newUser: User): ResponseEntity<Void> {
        return if (userRepository.existsById(newUser.id)) {
            ResponseEntity(HttpStatus.CONFLICT)
        } else {
            userRepository.save(newUser)
            ResponseEntity(HttpStatus.CREATED)
        }
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") id: Long, @RequestBody userData: User): ResponseEntity<Void> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            userRepository.save(userData)
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Long): ResponseEntity<Void> {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}