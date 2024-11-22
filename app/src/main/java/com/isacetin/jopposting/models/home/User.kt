package com.isacetin.jopposting.models.home

import com.isacetin.jopposting.util.capitalizeWords

data class User(
    val activated: Boolean?,
    val createdBy: String?,
    val createdDate: String?,
    val email: String?,
    val firstName: String?,
    val id: Int?,
    val imageUrl: String?,
    val langKey: String?,
    val lastModifiedBy: String?,
    val lastModifiedDate: String?,
    val lastName: String?,
    val login: String?,
    val resetDate: String?
)

fun User.name(): String = (this.firstName + " " + this.lastName).capitalizeWords()
