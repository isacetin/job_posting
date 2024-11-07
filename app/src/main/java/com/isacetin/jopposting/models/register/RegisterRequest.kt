package com.isacetin.jopposting.models.register

data class RegisterRequest(
    val email: String,
    val firstName: String,
    val lastName: String,
    val login: String,
    val password: String
)
