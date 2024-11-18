package com.isacetin.jopposting.models.register

data class RegisterResponse(
    val activated: Boolean,
    val createdBy: String,
    val createdDate: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val imageUrl: Any,
    val langKey: Any,
    val lastModifiedBy: String,
    val lastModifiedDate: String,
    val lastName: String,
    val login: String,
    val resetDate: Any
)
