package com.example.hellowworldkotlin.repository

import com.example.hellowworldkotlin.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>