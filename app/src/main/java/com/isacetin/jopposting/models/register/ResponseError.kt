package com.isacetin.jopposting.models.register

data class ResponseError(
    val detail: String,
    val instance: String,
    val message: String,
    val params: String,
    val path: String,
    val status: Int,
    val title: String,
    val type: String
)
