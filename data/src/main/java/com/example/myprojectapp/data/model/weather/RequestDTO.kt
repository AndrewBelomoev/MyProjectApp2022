package com.example.myprojectapp.data.model.weather

data class RequestDTO(
    val language: String? = null,
    val query: String? = null,
    val type: String? = null,
    val unit: String? = null,
)