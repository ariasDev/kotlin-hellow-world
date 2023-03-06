package com.example.hellowworldkotlin.domain

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
class User(
        @Id
        val id: Long,

        @Column
        val name: String,

        @Column
        val phoneNumber: String,

        @Column
        val address: String,

        @Column
        val email: String
) {
        // Agregar un constructor sin argumentos
        constructor() : this(0, "", "", "", "")
}