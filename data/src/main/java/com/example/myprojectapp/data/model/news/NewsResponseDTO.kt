package com.example.myprojectapp.data.model.news

data class NewsResponseDTO(
    val articles: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)